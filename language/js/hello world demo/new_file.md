###jquery学习

####1，jquery on() 方法可以自定义事件
	//自定义了一个click.fileupload.data-api事件
	$('body').on('click.fileupload.data-api', '[data-provides="fileupload"]', function(e) {
				var $this = $(this)
				$this.fileupload();
	});

####2. on方法里可以自定义筛选的数据
	//<div data-provides="fileupload"></div>
	//筛选了 data-provides="fileupload" 的属性
	$('body').on('click.fileupload.data-api', '[data-provides="fileupload"]', function(e) {
				var $this = $(this)
				$this.fileupload();
	});
####3. on方法里的function参数e可以获取时间的相关信息

####4. $.fn.fileupload = funcuntion(){}; 定义了一个叫fileuoload的方法
	$.fn.fileupload = function() {
				return this.each(function(){
					alert("123");
				});
	}

####4. $.this.each方法可以遍历所有符合条件的数据的子数据
	$.fn.fileupload = function() {
				return this.each(function(){
					alert("123");
				});
	}

	//each方法走两次
    <div data-provides="fileupload">123
		<div data-provides="fileupload">123</div>
	</div>

	//each方法走一次
	<div data-provides="fileupload">123</div>
	<div data-provides="fileupload">123</div>
	