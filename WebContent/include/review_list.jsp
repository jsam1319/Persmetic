<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list}" var="i">
                           	<div class="input-group">
                           		<div class="col-md-2">
									<p>${i.ctmNo}</p>
									<p>${i.reviewGrade}</p>
                           		</div>
                           		<div class="col-md-8">
                           			<p>${i.productCode}</p>
                           			<p>${i.reviewTitle}</p>
                           		</div>
                           		<div class="col-md-2">
                           			<p>${i.reviewDate}</p>
                           		</div>
                           	</div>
                           		<hr>
                           	</c:forEach>
                           <input type="button" value="리뷰쓰기" id="reviewbtn" class="btn btn-primary">
                            <!-- Paging -->
					<div class="pages">

						<nav aria-label="Page navigation">
								<ul class="pagination">
									<c:if test="${pageBuilder.isShowFirst()}">
										<li><a href="${pageBuilder.getQueryString(1)}"> << </a></li>
									</c:if>

									<c:if test="${pageBuilder.isShowPrevious()}">
										<li class="prev"><a
											href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}"> < </a></li>
									</c:if>

									<c:forEach var="i" begin="${pageBuilder.currentStartPage }"
										end="${pageBuilder.currentEndPage}" varStatus="status">
										<c:choose>
											<c:when test="${i==params.page}">
												<li class="active"><a>${i}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageBuilder.getQueryString(i)}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${pageBuilder.isShowNext()}">
										<li class="next"><a
											href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}"> > </a></li>
									</c:if>

									<c:if test="${pageBuilder.isShowLast()}">
										<li><a
											href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}"> >> </a></li>
									</c:if>

								</ul>
							</nav>
					</div>

					<!-- /.Paging --> 