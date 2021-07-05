<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${mensaje != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-info">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>
 	<div class="columns is-centered">
		<div class="column is-8">
			<form method="POST" action="VerAsistentesController.do">
				<div class="field">
					<label class="label has-text-centered" for="filtro-select">Estado
						de Deuda</label>
					<div class="control has-text-centered">
						<div class="select">
							<select name="filtro-select" id="filtro-select">
								<!-- <option>Seleccione</option> -->
								<option>Pagada</option>
								<option>Con Deuda</option>
							</select>
						</div>
						<div class="card-footer has-text-centered">
							<div class="card-footer-item">
								<button type="submit" class="button is-info">Filtrar</button>
							</div>
						</div>
					</div>
				</div>


				<table class="table is-hovered is-bordered is-fullwidth">
					<thead class="has-background-primary">
						<tr>
							<th>Nombre Completo</th>
							<th>Empresa</th>
							<th>Región</th>
							<th>Estado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="asistente" items="${asistentes}">
							<tr>
								<td>${asistente.nombre} ${asistente.apellido}</td>
								<td>${asistente.empresa}</td>
								<td>${asistente.region}</td>
								<td>${asistente.estado}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="columns">
					<div class="column is-6">
						<label>Total asistentes registrados: ${numero}</label>
					</div>
				</div>
			</form>
		</div>
	</div>
</main>
</body>
</html>