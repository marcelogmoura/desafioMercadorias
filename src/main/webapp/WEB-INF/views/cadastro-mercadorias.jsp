<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Mercadorias</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />
	
	<style> 
	label.error { color: #d9534f; }
	input.error { border: 2px solid #d9534f; }
	</style>

</head>
<body>

		<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4">

			<h2 class="text-center">Cadastro de Mercadorias</h2>
			<p class="text-center">Preencha os campos abaixo</p>
			
			<h5>${mensagem}</h5>

			<form id="cadastroMercadoria" method="post" action="cadastro-mercadorias-post">

				<div class="mb-2">
					<label for="nomeMercadoria" class="form-label"> Mercadoria:</label>
					<input type="text" class="form-control" id="nomeMercadoria" name="nomeMercadoria"
						placeholder="Informe o nome">
				</div>

				<div class="mb-2">
					<label for="descricao" class="form-label"> Descrição:</label> <input
						type="text" class="form-control" id="descricao" name="descricao"
						placeholder="Informe a descrição">
				</div>

				<div class="mb-2">
					<label for="quantidade" class="form-label"> Quantidade:</label> <input
						type="text" class="form-control" id="quantidade" name="quantidade"
						placeholder="Informe a quantidade">
				</div>

				<div class="mb-2">
					<label for="dataEntrada" class="form-label"> Data Entrada:</label>
					<input type="date" class="form-control" id="dataEntrada" name="dataEntrada"
						placeholder="Informe a data">
				</div>

				<div class="md-2">
					<label>Tipo de Alimento:</label> <select id="tipo" name="tipo"
						class="form-select">
						<option value="">Selecione uma opção</option>
						<option value="1">Perecível</option>
						<option value="2">Não Perecível</option>
					</select>
				</div>
				<hr>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">Cadastrar </button>
				</div><p>

				<div class="d-grid">
					<button type="submit" class="btn btn-dark">Pesquisar</button>
				</div>

			</form>

		</div>
	</div>
		
			<script src="resources/js/bootstrap.bundle.min.js"></script>
			<script src="resources/js/bootstrap.bundle.min.js"></script>
			<script src="resources/js/jquery-3.7.0.min.js"></script>
			<script src="resources/js/jquery.validate.min.js"></script>
			<script src="resources/js/additional-methods.min.js"></script>
			<script src="resources/js/messages_pt_BR.min.js"></script>

	<script>
		$(document).ready(function() {		
			$("#cadastroMercadoria").validate({
				rules : {
					"nomeMercadoria" : {
						required : true,
						minlength : 8,
						maxlength : 100
					},
					"descricao" : {
						required : true,
					},
					"quantidade" : {
						required : true
					},
					"dataEntrada" : {
						required : true,
					},
					"tipo" : {
						required : true,
					}
				}
			});
		})
	</script>

</body>
</html>