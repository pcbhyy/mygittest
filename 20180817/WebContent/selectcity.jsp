<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	省份:
	<select name="province" id="province" >
		<option value="省份" selected="selected">省份</option>
	</select> 城市:
	<select name="city" id="city">
		<option value="城市" selected="selected">市县</option>
	</select>
</body>
<script type="text/javascript">
	var province = document.getElementById('province');
	var city = document.getElementById("city");
	var provinceArr = [];
	provinceArr[0] = [ '北京市' ];
	provinceArr[1] = [ '天津市' ];
	provinceArr[2] = [ '上海市' ];
	provinceArr[3] = [ '重庆市' ];
	//市县,每个数组第一个元素为省份,其他的为这个省份下的市县,
	var cityArr = [];
	cityArr[0] = [ '北京市', '东城区', '西城区', '崇文区', '宣武区', '朝阳区' ];
	cityArr[1] = [ '天津市', '和平区', '河东区', '河酉区', '南开区', '河北区' ];
	cityArr[2] = [ '上海市', '黄埔区', '卢湾区', '徐汇区', '长宁区', '静安区' ];
	cityArr[3] = [ '重庆市', '万州区', '涪陵区', '渝中区', '大渡口区', '江北区' ];
	//改变事件已经完成,生成省份的代码如下:
	//生成省份
	for ( var key in provinceArr) {
		//var provinceOption = document.createElement ('option');
		//ie不支持option对象的value,所以加childOption.text
		//provinceOption.value = provinceOption.text = provinceArr[key];
		//ie不支持option对象的value,所以加childOption.text
		var provinceOption = new Option(provinceArr[key], provinceArr[key]);
		province.options.add(provinceOption);
	}
	//省份改变市,
	province.onchange = function() {
		showChild(province, city, cityArr);
	}
	//生成市县、区市
	//@current为当前选择的select节点，即父类节点 
	//@child为子类点 
	//@childArr为子节点数组 
	function showChild(current, child, childArr) {
		var currentValue = current.value;
		
		//清空原来的加载的所有城市名
		child.options.length = 1;
		
		for(var i = 0; i < childArr.length;i++){
			if(currentValue == childArr[i][0]){
				for(var j = 1;j<childArr[i].length; j++){
					//var o = new Option(childArr[i][j],childArr[i][j]);
					var cityOption = document.createElement("option");
					cityOption.value = cityOption.text = childArr[i][j];
					child.options.add(cityOption);
				}
				
				break;
			}
		}
		
	}
</script>
</html>







