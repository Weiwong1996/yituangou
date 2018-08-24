<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<!-- 手指在滑动整个屏幕时，会影响浏览器的行为，比如滚动和缩放。所以在调用touch事件时，要注意禁止缩放和滚动 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<style>
/* 滑动控件容器,亮灰色背景 */
#dragContainer {
	position: relative;
	display: inline-block;
	background: #e8e8e8;
	width: 300px;
	height: 50px;
	border: 2px solid #e8e8e8;
}
/* 滑块左边部分,绿色背景 */
#dragBg {
	position: absolute;
	background-color: #7ac23c;
	width: 0px;
	height: 100%;
}
/* 滑动验证容器文本 */
#dragText {
	position: absolute;
	width: 100%;
	height: 100%;
	/* 文字水平居中 */
	text-align: center;
	/* 文字垂直居中,这里不能用百分比,因为百分比是相对原始line-height的,而非div高度 */
	line-height: 50px;
	/* 文本不允许选中 */
	user-select: none;
	-webkit-user-select: none;
}
/* 滑块 */
#dragHandler {
	position: absolute;
	width: 50px;
	height: 100%;
	cursor: move;
}
/* 滑块初始背景 */
.dragHandlerBg {
	background: #fff no-repeat center
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDIxIDc5LjE1NTc3MiwgMjAxNC8wMS8xMy0xOTo0NDowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo0ZDhlNWY5My05NmI0LTRlNWQtOGFjYi03ZTY4OGYyMTU2ZTYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NTEyNTVEMURGMkVFMTFFNEI5NDBCMjQ2M0ExMDQ1OUYiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NTEyNTVEMUNGMkVFMTFFNEI5NDBCMjQ2M0ExMDQ1OUYiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTQgKE1hY2ludG9zaCkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo2MTc5NzNmZS02OTQxLTQyOTYtYTIwNi02NDI2YTNkOWU5YmUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NGQ4ZTVmOTMtOTZiNC00ZTVkLThhY2ItN2U2ODhmMjE1NmU2Ii8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+YiRG4AAAALFJREFUeNpi/P//PwMlgImBQkA9A+bOnfsIiBOxKcInh+yCaCDuByoswaIOpxwjciACFegBqZ1AvBSIS5OTk/8TkmNEjwWgQiUgtQuIjwAxUF3yX3xyGIEIFLwHpKyAWB+I1xGSwxULIGf9A7mQkBwTlhBXAFLHgPgqEAcTkmNCU6AL9d8WII4HOvk3ITkWJAXWUMlOoGQHmsE45ViQ2KuBuASoYC4Wf+OUYxz6mQkgwAAN9mIrUReCXgAAAABJRU5ErkJggg==");
}
/* 验证成功时的滑块背景 */
.dragHandlerOkBg {
	background: #fff no-repeat center
		url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDIxIDc5LjE1NTc3MiwgMjAxNC8wMS8xMy0xOTo0NDowMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo0ZDhlNWY5My05NmI0LTRlNWQtOGFjYi03ZTY4OGYyMTU2ZTYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NDlBRDI3NjVGMkQ2MTFFNEI5NDBCMjQ2M0ExMDQ1OUYiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NDlBRDI3NjRGMkQ2MTFFNEI5NDBCMjQ2M0ExMDQ1OUYiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTQgKE1hY2ludG9zaCkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDphNWEzMWNhMC1hYmViLTQxNWEtYTEwZS04Y2U5NzRlN2Q4YTEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NGQ4ZTVmOTMtOTZiNC00ZTVkLThhY2ItN2U2ODhmMjE1NmU2Ii8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+k+sHwwAAASZJREFUeNpi/P//PwMyKD8uZw+kUoDYEYgloMIvgHg/EM/ptHx0EFk9I8wAoEZ+IDUPiIMY8IN1QJwENOgj3ACo5gNAbMBAHLgAxA4gQ5igAnNJ0MwAVTsX7IKyY7L2UNuJAf+AmAmJ78AEDTBiwGYg5gbifCSxFCZoaBMCy4A4GOjnH0D6DpK4IxNSVIHAfSDOAeLraJrjgJp/AwPbHMhejiQnwYRmUzNQ4VQgDQqXK0ia/0I17wJiPmQNTNBEAgMlQIWiQA2vgWw7QppBekGxsAjIiEUSBNnsBDWEAY9mEFgMMgBk00E0iZtA7AHEctDQ58MRuA6wlLgGFMoMpIG1QFeGwAIxGZo8GUhIysmwQGSAZgwHaEZhICIzOaBkJkqyM0CAAQDGx279Jf50AAAAAABJRU5ErkJggg==");
}
</style>
<script>
	window.onload = function() {
		var dragContainer = document.getElementById("dragContainer");
		var dragBg = document.getElementById("dragBg");
		var dragText = document.getElementById("dragText");
		var dragHandler = document.getElementById("dragHandler");
		var divleft = dragContainer.getBoundingClientRect().left;

		//滑块最大偏移量
		var maxHandlerOffset = dragContainer.clientWidth
				- dragHandler.clientWidth;
		//是否验证成功的标记
		var isVertifySucc = false;
		initDrag();

		function initDrag() {
			dragText.textContent = "拖动滑块验证";
			dragHandler.addEventListener("mousedown", onDragHandlerMouseDown);

			dragHandler.addEventListener("touchstart", onDragHandlerMouseDown);
		}

		function onDragHandlerMouseDown(event) {
			document.addEventListener("mousemove", onDragHandlerMouseMove);
			document.addEventListener("mouseup", onDragHandlerMouseUp);

			document.addEventListener("touchmove", onDragHandlerMouseMove);
			document.addEventListener("touchend", onDragHandlerMouseUp);
		}

		function onDragHandlerMouseMove(event) {
			/*
			html元素不存在width属性,只有clientWidth
			offsetX是相对当前元素的,clientX和pageX是相对其父元素的

			touches：表示当前跟踪的触摸操作的touch对象的数组。
			targetTouches：特定于事件目标的Touch对象的数组。
			changedTouches：表示自上次触摸以来发生了什么改变的Touch对象的数组。
			 */
			var left = (event.clientX || event.changedTouches[0].clientX)
					- dragHandler.clientWidth / 2 - divleft;
			if (left < 0) {
				left = 0;
			} else if (left > maxHandlerOffset) {
				left = maxHandlerOffset;
				verifySucc();
			}
			dragHandler.style.left = left + "px";
			dragBg.style.width = dragHandler.style.left;
		}
		function onDragHandlerMouseUp(event) {
			document.removeEventListener("mousemove", onDragHandlerMouseMove);
			document.removeEventListener("mouseup", onDragHandlerMouseUp);

			document.removeEventListener("touchmove", onDragHandlerMouseMove);
			document.removeEventListener("touchend", onDragHandlerMouseUp);

			dragHandler.style.left = 0;
			dragBg.style.width = 0;
		}

		//验证成功
		function verifySucc() {
			isVertifySucc = true;
			dragText.textContent = "验证通过";
			dragText.style.color = "white";
			dragHandler.setAttribute("class", "dragHandlerOkBg");

			dragHandler
					.removeEventListener("mousedown", onDragHandlerMouseDown);
			document.removeEventListener("mousemove", onDragHandlerMouseMove);
			document.removeEventListener("mouseup", onDragHandlerMouseUp);

			dragHandler.removeEventListener("touchstart",
					onDragHandlerMouseDown);
			document.removeEventListener("touchmove", onDragHandlerMouseMove);
			document.removeEventListener("touchend", onDragHandlerMouseUp);
		}
		;
	}
</script>
</head>
<body>
	<div id="dragContainer" style="position: absolute; left: 300px;">
		<div id="dragBg"></div>
		<div id="dragText"></div>
		<div id="dragHandler" class="dragHandlerBg"></div>
	</div>
</body>
</html>
