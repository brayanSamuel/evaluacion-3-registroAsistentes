<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${errores != null }">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-danger">
					<h6>Existen errores en el formulario</h6>
					<div class="content">
						<ul>
							<c:forEach var="error" items="${errores}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="AgregarAsistenteController.do">
				<div class="card">
					<div class="card-header has-background-success">
						<span class="card-header-title is-centered">Ingresar Participante</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="rut-txt">Rut (sin puntos y con guion)</label>
							<div class="control">
								<input type="text" class="input" id="rut-txt" name="rut-txt" />
							</div>
						</div>

						<div class="field">
							<label class="label" for="nombre-txt">Nombre</label>
							<div class="control">
								<input type="text" class="input" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="apellido-txt">Apellido</label>
							<div class="control">
								<input type="text" class="input" id="apellido-txt"
									name="apellido-txt" />
							</div>
						</div>
						<div class="field">
								<label class="label" for="edad-txt">Edad (mayor o igual a 18)</label>
								<div class="control">
									<input type="number" class="input" name="edad-txt" id="edad-txt"/>
								</div>
						</div>
						<div class="field">
							<label class="label" for="empresa-txt">Empresa</label>
							<div class="control">
								<input type="text" class="input" id="empresa-txt"
									name="empresa-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="estado-select">Estado</label>
							<div class="control">
								<div class="select">
									<select name="estado-select" id="estado-select">
										<option>Pagada</option>
										<option>Con Deuda</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="region-select">Región</label>
							<div class="control">
								<div class="select">
									<select name="region-select" id="region-select">
										<option>Valparaíso</option>
										<option>Santiago</option>
										<option>Norte de chile</option>
										<option>Sur de Chile</option>
										<option>internacional</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Ingresar Solicitud</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>