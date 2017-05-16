/**
 项目JS主入口
 以依赖Layui的layer和form模块为例
 **/
layui.define(['element','layer'], function(exports){
    var element = layui.element(), //导航的hover效果、二级菜单等功能，需要依赖element模块
        layer = layui.layer,
        $ = layui.jquery;

    //触发事件
    var active = {
        tabAdd: function(){
            //新增一个Tab项
            element.tabAdd('demo', {
                title: '新选项'+ (Math.random()*1000|0) //用于演示
                ,content: '内容'+ (Math.random()*1000|0)
                ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
            })
        }
        ,tabDelete: function(othis){
            //删除指定Tab项
            element.tabDelete('demo', '44'); //删除：“商品管理”


            othis.addClass('layui-btn-disabled');
        }
        ,tabChange: function(){
            //切换到指定Tab项
            element.tabChange('demo', '22'); //切换到：用户管理
        }
    };

    $('.site-demo-active').on('click', function(){
        var othis = $(this), type = othis.data('type');
        active[type] ? active[type].call(this, othis) : '';
    });

    //监听导航点击
    element.on('nav(demo)', function(elem){
        //console.log(elem)
        layer.msg(elem.text());
    });
    exports('index', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});