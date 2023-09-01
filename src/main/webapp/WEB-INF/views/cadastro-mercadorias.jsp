<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Mercadorias</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	type="text/css" />

</head>
<body>


	<div
		class="container d-flex justify content-center align-items-center vh-20">
		<div class="card p-4">

			<h2 class="text-center">Cadastro de Mercadorias</h2>
			<p class="text-center">Preencha os campos abaixo</p>

			<form>

				<div class="mb-2">
					<label for="nomeMercadoria" class="form-label"> Mercadoria:</label>
					<input type="text" class="form-control" id="nomeMercadoria"
						placeholder="Informe o nome">
				</div>

				<div class="mb-2">
					<label for="descricao" class="form-label"> Descrição:</label> <input
						type="text" class="form-control" id="descricao"
						placeholder="Informe a descrição">
				</div>

				<div class="mb-2">
					<label for="quantidade" class="form-label"> Quantidade:</label> <input
						type="text" class="form-control" id="quantidade"
						placeholder="Informe a quantidade">
				</div>

				<div class="mb-2">
					<label for="dataEntrada" class="form-label"> Data Entrada:</label>
					<input type="date" class="form-control" id="dataEntrada"
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

</body>
</html>