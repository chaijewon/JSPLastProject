<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#findBtn').click(function(){
		let types=[]
		let count=$('input[name=type]:checked').length
		if(count==0)
		{
			alert("체크박스에 체크하세요!!")
			return
		}
		$('input[name=type]:checked').each(function(){
			types.push($(this).val())
		})
		let fd=$('#fd').val()
		if(fd.trim()==="")
		{
			$('#fd').focus()
			return
		}
		let column=$('#column').val()
		console.log(types)
		console.log("검색어:"+fd)
		console.log("컬럼명:"+column)
		// 배열 => traditional 
		$.ajax({
			type:'post',
			url:'../food/find_ajax.do',
			data:{"fd":fd,"column":column,"type":types},
			traditional:true,
			success:function(result)
			{
				let json=JSON.parse(result)
				console.log(json)
				$('#count').text(json[0].count)
			}
		})
	})
})
</script>
</head>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>맛집 검색</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                          <!-- <form method="post" action="../food/find.do"> -->
                            <input type="checkbox" name=type value="A">한식
                            <input type="checkbox" name=type value="B">일식
                            <input type="checkbox" name=type value="C">중식
                            <input type="checkbox" name=type value="D">양식
                            <input type="checkbox" name=type value="E">분식
                            <select name="column" id="column" class="input-sm">
                              <option value="address">주소</option>
                              <option value="name">업체명</option>
                              <option value="theme">테마</option>
                            </select>
                            <input type=text name=fd id="fd" class="input-sm">
                            <input type=button value="검색"
                             class="btn-sm btn-danger" id="findBtn">
                            <!-- </form> -->
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80">
        <div class="container">
            <div class="row">
             <h3>총 검색 결과 <span id="count"></span> </h3>
            </div>
        </div>
    </section>

</body>
</html>