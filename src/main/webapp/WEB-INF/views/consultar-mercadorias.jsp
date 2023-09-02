<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar Mercadorias</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="resources/css/jquery.dataTables.min.css" type="text/css" />

	<style> 
	label.error { color: #d9534f; }
	input.error { border: 2px solid #d9534f; }
	</style>

</head>
<body>

	<!-- componente messages -->
	<jsp:include page="/WEB-INF/views/components/messages.jsp"></jsp:include>


		<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-5">

			<h2 class="text-center">Consulta de Mercadorias</h2>
			
			<h5>${mensagem}</h5>			
				
				<form id="consultarMercadoria" method="post"  action="consultar-mercadorias-post">

				<div class="row mb-2">
				
					<div class="col-md-4">
						<input type="date" id="dataInicio" name="dataInicio"
							class="form-control" value="${dt_inicio}"/>
					</div>
					
					<div class="col-md-4">
						<input type="date" id="dataFim" name="dataFim"
							class="form-control" value="${dt_fim}"/>
					</div>
					
					<div class="col-md-4">
						<input type="submit" value="Pesquisar"
							class="btn btn-dark" />
					</div><p>
					
					<div class="d-grid mt-2">
					<a href="/desafioMercadorias" class="btn btn-light">
						Clique aqui cadastrar uma mercadoria </a>
				</div>
				
				<div class="mt-3 table-responsive">
					<table id="tabela" class="table table-sm">
						<thead>
							<tr>
								<th>Nome da mercadoria</th>		
								<th>Data da Entrada</th>						
								<th>Quantidade</th>
								<th>Tipo</th>
								<th>Descrição</th>	
							</tr>
						</thead>
						<tbody>
						
						<c:forEach items="${lista_mercadorias}" var="mercadoria">
												
							<tr>
								<td>${mercadoria.nomeMercadoria}</td>
								<td>
								<fmt:formatDate value="${mercadoria.dataEntrada}" pattern="EEE, dd/MM/yyyy"/>
								</td>
								<td>${mercadoria.quantidade}</td>
								<td>
									<c:if test="${mercadoria.tipo == 2}">
										<span class="badge bg-warning">NÃO PERECÍVEL</span>
									</c:if>
									<c:if test="${mercadoria.tipo == 1}">
										<span class="badge bg-info">PERECÍVEL</span>
									</c:if>
								</td>
								<td>${mercadoria.descricao}</td>

							</tr>	
							
							</c:forEach>
													
						</tbody>
					</table>
				</div>
					
					</form>
				</div><p>
				
				</div>
				
				</div>
				

			<script src="resources/js/bootstrap.bundle.min.js"></script>
			<script src="resources/js/bootstrap.bundle.min.js"></script>
			<script src="resources/js/jquery-3.7.0.min.js"></script>
			<script src="resources/js/jquery.validate.min.js"></script>
			<script src="resources/js/additional-methods.min.js"></script>
			<script src="resources/js/messages_pt_BR.min.js"></script>
			<script src="resources/js/jquery.dataTables.min.js"></script>
			
				<script>
		$(document).ready(function() {		
			$("#consultarMercadoria").validate({
				rules : {
					"nomeMercadoria" : {
						required : true,
						minlength : 3,
						maxlength : 100
					},
					"descricao" : {
						required : true
					},
					"quantidade" : {
						required : true
					},
					"dataInicio" : {
						required : true
					},
					"dataFim" : {
						required : true
					},
					"tipo" : {
						required : true,
					}
				}
			});
			
			$("#tabela").DataTable({
				language: {
				url: 'resources/js/dataTables.pt-BR.json'
				}			
		})
	</script>
			
</body>
</html>