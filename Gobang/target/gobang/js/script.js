// 几个重要参数的解释
// userId: 用户登陆时获取到的（测试阶段，我们下写死）
// roomId：当前这局游戏的房间号。通过匹配结果获取到
// isWhile： 当前这局游戏是否包含白子。通过匹配结果获取到
// 这三个属性包裹到一个gameInfo 对象中

gameInfo = {
    userId: myUserId,
    roomId: null,
    isWhite: true,
}
//////////////////////////////////////////
// 设定界面显示相关操作
///////////////////////////////////////////

function onClick(userId) {
    startMatch(userId);
    // 将按钮设置为不可点击, 并修改文本
    $("#matchButton").attr('disabled', true);
    $("#matchButton").text("匹配中...");
}

function hideMatchButton() {
    $("#matchButton").hide();
}

function setScreenText(me) {
    if (me) {
        $("#screen").text("轮到你落子了!!!");
    } else {
        $("#screen").text("轮到对方落子了!!!");
    }
}

/////////////////////////////////////////////
// 初始化 websocket
/////////////////////////////////////////////
var webSocket = new WebSocket("ws://39.105.62.35:8080/Gobang/game/" + gameInfo.userId);

// 给 websocket 对象实现对应的方法
webSocket.onopen = function () {
    console.log("连接建立成功！" + gameInfo.userId);
}

webSocket.onclose = function () {
    console.log("连接断开！" + gameInfo.userId);
}

webSocket.onerror = function () {
    console.log("连接异常！" + gameInfo.userId);
}

webSocket.onmessage = function () {

}


window.onbeforeunload = function () {
    webSocket.close();
}
//////////////////////////////////////////////
// 实现匹配逻辑
/////////////////////////////////////////////
function startMatch(userId) {
    // 1.设置处理响应的函数
    webSocket.onmessage = handlerStartMatch;
    // 2.先构造要发送的数据内容
    var message = {
        type: 'startMatch',
        userId: userId
    };
    // 3.发送数据给服务器
    webSocket.send(JSON.stringify(message));
}

function handlerStartMatch(event) {
    // 1.读取响应内容
    var response = JSON.parse(event.data); // 才能得到真实的服务器返回数据
    console.log("handlerStartMatch" + event.data);
    // 2.过滤非法的响应类型
    if (response.type != "startMatch") {
        // 服务器响应的数据不对，直接忽略错误数据
        console.log("非法匹配！");
        return;
    }
    // 3.把响应的结果保存到 gameInfo 对象中 gameInfo.roomId = response.roomId;
    gameInfo.roomId = response.roomId;
    gameInfo.isWhile = response.isWhite;
    gameInfo.otherUserId = response.otherUserId;
    // 4.隐藏匹配按钮
    hideMatchButton();
    // 5.设置提示信息（轮到谁落子）
    //      参数为true表示自己落子，参数为false 表示对方落子
    //      白旗先走
    setScreenText(gameInfo.isWhile);
    console.log("匹配正常")
    // 6.初始化一局游戏
    initGame();
}

///////////////////////////////////////////////////
//  匹配成功，则初始化一局游戏 (在匹配成功后，绘制棋盘)
///////////////////////////////////////////////////
function initGame() {
    // 是我下还是对方下。根据服务器分配的先后手情况决定
    var me = gameInfo.isWhite;
    // 游戏是否结束
    var over = false;
    var chessBoard = [];
    // 初始化chessBoard数组(表示棋盘的数组)
    for (var i = 0; i < 15; i++) {
        chessBoard[i] = [];
        for (var j = 0; j < 15; j++) {
            chessBoard[i][j] = 0;
        }
    }
    var chess = document.getElementById('chess');
    var context = chess.getContext('2d');
    context.strokeStyle = "#BFBFBF";

    // 背景图片
    var logo = new Image();
    logo.src = "images/sky.jpeg";
    logo.onload = function () {
        context.drawImage(logo, 0, 0, 450, 450);
        initChessBoard();
    }

    // 绘制棋盘网络
    function initChessBoard() {
        for (var i = 0; i < 15; i++) {
            // 画竖线
            context.moveTo(15 + i * 30, 15);
            context.lineTo(15 + i * 30, 435);
            context.stroke(); // 绘制已定义路径
            // 画横线
            context.moveTo(15, 15 + i * 30);
            context.lineTo(435, 15 + i * 30);
            context.stroke(); // 绘制已定义路径
        }
    }

    // 绘制一个棋子，me为true
    function oneStep(i, j, isWhite) {
        // 起始一条路径，或重置当前路径
        context.beginPath();
        // 绘制圆
        context.arc(15 + i * 30, 15 + j * 30, 13, 0, 2 * Math.PI);
        // 创建从当前点回到起始点的路径
        context.closePath();
        // 创建放射状/环形的渐变（用在画布内容上）,使棋子看起来更立体
        var gradient = context.createRadialGradient(15 + i * 30 + 2, 15 + j * 30 - 2, 13, 15 + i * 30 + 2, 15 + j * 30 - 2, 0)
        if (!isWhite) {
            gradient.addColorStop(0, "#0A0A0A");
            gradient.addColorStop(1, "#636766");
        } else {
            gradient.addColorStop(0, "#D1D1D1");
            gradient.addColorStop(1, "#F9F9F9");
        }
        context.fillStyle = gradient;
        context.fill();
    }

    /*
      若 用户1 已经下完就不应该下棋了，定义变量IsUser1Play，若isUser1Play为true表示已经下过了。
      用户2同理。
     */
    var isUser1Play = false;
    var isUser2Play = false;
    chess.onclick = function (e) {
        if (over) {
            console.log("over被执行");
            return;
        }
        if (!me) {
            console.log("!me被执行");
            return;
        }
        var x = e.offsetX;
        var y = e.offsetY;
        // 注意横坐标是列，纵坐标是行
        var col = Math.floor(x / 30);
        var row = Math.floor(y / 30);
        if (chessBoard[row][col] == 0) {
            //  新增发送数据给服务器的逻辑
            send(row, col);
        }
    }

    function send(row, col) {
        console.log("send :" + row + "," + col);
        var request = {
            type: "putChess",
            userId: gameInfo.userId,
            roomId: gameInfo.roomId,
            row: row,
            col: col
        }
        webSocket.send(JSON.stringify(request));
    }


    // 新增处理服务器返回数据的请求
    //       并绘制棋子，以及判定胜负
    function handlerPutChess(event) {
        console.log("handlerPutChess:" + event.data);
        // event.data 是一个字符串，需要转成一个JSON对象
        // 1.读取响应内容
        var response = JSON.parse(event.data);
        if (response.type != "putChess") {
            console.log("handlerPutChess：响应内容不匹配");
            return;
        }
        // 2.根据响应内容，决定绘制那种颜色的棋子
        if (response.userId == gameInfo.userId) {
            // 当前的棋子是自己落得，于是就根据自己的isWhile来绘制棋子
            oneStep(response.col, response.row, gameInfo.isWhile);
            me = gameInfo;
        } else {
            // 当前的棋子是对方落的，于是就根据对方的isWhile来绘制棋子
            oneStep(response.col, response.row, !gameInfo.isWhile);
            me = !gameInfo;
        }
        // 3.给棋盘数组记录位置（防止同一个位置被多次落子）
        chessBoard[response.row][response.col] = 1;
        // 4.处理胜负
        if (response.winner != 0) {
            if (response.winner == gameInfo.userId) {
                alert("您赢了");
            } else {
                alert("您输了");
            }
            // 自动刷新页面，已被进行下一句游戏
            // 一旦页面刷新，当前这里的 js 变量，状态就没有了
            window.location.reload();
        }
        // 落子顺序控制
        me = !me; // 经过这样的操作，就能够使得点击事件无法生效，等对方下完之后才可以
        console.log(me);
        // 更新界面显示 轮到xx落子
        setScreenText(me);
    }

    webSocket.onmessage = handlerPutChess;
}
