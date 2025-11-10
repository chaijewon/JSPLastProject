<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                            <input type="checkbox" name=type value="A">한식
                            <input type="checkbox" name=type value="B">일식
                            <input type="checkbox" name=type value="C">중식
                            <input type="checkbox" name=type value="D">양식
                            <input type="checkbox" name=type value="E">분식
                            <select name="column" class="input-sm">
                              <option value="address">주소</option>
                              <option value="name">업체명</option>
                              <option value="theme">테마</option>
                            </select>
                            <input type=text name=fd class="input-sm">
                            <input type=button value="검색"
                             class="btn-sm btn-danger">
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
            </div>
        </div>
    </section>

</body>
</html>