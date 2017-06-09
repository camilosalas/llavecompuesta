<%@page import="ofelia.model.entity.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ofelia.model.dao.impl.PersonaDaoImpl"%>
<%@page import="ofelia.model.dao.PersonaDAO"%>

<jsp:useBean id="ListarAlumno" scope="request" type="java.util.List<Persona>"/>
<!DOCTYPE html>
<html>

    <%@include file="include/head.jsp" %>

<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <%@include file="include/header.jsp" %>

        <%@include file="include/aside.jsp" %>


        <div class="content-wrapper">
            <section class="content-header">
                <h1 class="epic-nav-item-heading " aria-selected="true">
                    MÓDULO REGISTRO
                    <small>Registrar Alumno</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="inicio.jsp"><i class="glyphicon glyphicon-home"></i> Inicio</a></li>
                    <li class="active">Registro</li>
                    <li class="active">Registrar alumno</li>
                </ol>
            </section>

            <section class="content">
                <div class="row">
                   
                    <div class="col-md-12">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#addAlumno">
                            <i class="ion-person-add"></i> Registrar alumno
                        </button>
                        <a href="ListarAlumno" class="btn btn-primary">
                                <i class="glyphicon glyphicon-refresh"></i> Actualizar</a>
                        
                        <br><br>
                    </div>
                    
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="box collapsed-box">
                            <div class="box-header with-border">
                                <h3 class="box-title"> Registro de alumnos</h3>
                            </div>

                            <div class="">
                                <div class="row">
                                    <div class="container-fluid">
                                        
                                           <div class="col-lg-12">
                                            <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                                                <div class="table-responsive">
                                                    
                                                    <table id="tablaAlumnos" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                                                        <thead>
                                                            <tr role="row">
                                                                <th>N°</th>
                                                                <th>Nombres</th>
                                                                <th>Apellidos</th>
                                                                <th>Género</th>
                                                                <th>Fecha de nacimiento</th>
                                                                <th>Tipo Doc</th> 
                                                                <th>N° Doc</th>                                                               
                                                                <th>Dirección</th>
                                                                <th>Acción</th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                             <%
                                                                int contador1 = 0;
                                                                for (Persona a : ListarAlumno) {
                                                                    contador1++;
                                                            %>
                                                            <tr role="row" class="odd">
                                                                <td class="sorting_1"><%= contador1%></td>
                                                                <td><%= a.getNombres() %></td>
                                                                <td><%= a.getApellidos() %></td>
                                                                <td><%= a.getGenero() %></td>
                                                                <td><%= a.getFecha_nac() %></td>
                                                                <td><%
                                                                        if (a.getIdtipo_doc()== 1){
                                                                                out.write("DNI");
                                                                            }
                                                                            if (a.getIdtipo_doc() == 2) {
                                                                                out.write("Pasaporte");
                                                                            }
                                                                
                                                                    %></td>
                                                                <td><%= a.getNro_doc() %></td>
                                                                <td><%= a.getDireccion() %></td>
                                                                <td>
                                                                    <center>
                                                                        <a class="btn btn-warning btn-xs" href="#"><i class="fa fa-pencil" aria-hidden="true"></i> </a>
                                                                        <a class="btn btn-danger btn-xs" href="#" role="button"><i class="fa fa-trash" aria-hidden="true"></i> </a>
                                                                    </center>
                                                                </td>
                                                            </tr>
                                                             <% }%>
                                                        </tbody>

                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

     <%@include file="include/footer.jsp" %>


        <div class="modal fade" id="addAlumno" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title"><i class="ion-person-add"></i> Agregar Alumno</h4>
                    </div>

                    <div class="modal-body">
                        <!--<div class="alert alert-warning" role="alert" style="opacity: 1.5">
                            <strong style="color: #ffffff;"><i class="icon fa fa-warning"></i>Advertencia: </strong>Asegúrate de llenar todos los campos *
                        </div>-->
                        
                        

                        <form action="ControlPersona" method="post" class="form-horizontal">
                            <input type="hidden" name="op" value="add_Alumno">

                            <div class="form-group">
                                <label for="nombreAlumno" class="col-sm-2 control-label">* Nombre:</label>
                                <div class="col-sm-4">
                                    <input name="nombres" type="text" autocomplete="off" class="form-control" placeholder="Nombre del alumno" title="Nombre del alumno">
                                </div>

                                <label for="apellidoAlumno" class="col-sm-2 control-label">* Apellido: </label>
                                <div class="col-sm-4">
                                    <input name="apellidos" type="text" autocomplete="off" class="form-control" placeholder="Apellido de alumno" title="Apellido del alumno">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="generoAlumno" class="col-sm-2 control-label">* Género: </label>
                                <div class="col-sm-4">
                                    <select name="genero" class="form-control" title="Género del Alumno">
                                      <option value="">Selecione su Sexo</option>
                                       <option value="1">Masculino</option>
                                       <option value="2">Femenino</option>
                                    </select>
                                </div>

                                <label for="fecha_nac" class="col-sm-2 control-label">* Fecha de nacimiento: </label>
                                <div class="col-sm-4">
                                    <input name="fecha_nac" type="date" autocomplete="off" class="form-control" placeholder="" title="Fecha de nacimiento">
                                </div>
                            </div>

                            <div class="form-group">
                                
                                <label for="nivelAlumno" class="col-sm-2 control-label">*Tipo Doc: </label>
                                <div class="col-sm-4">
                                    <select name="idtipo_doc" class="form-control" title="Tipo de documento">
                                        <option value="1">DNI</option>
                                        <option value="1">Exa</option>
                                    </select>
                                </div>
                                <label for="dniAlumno" class="col-sm-2 control-label">*Nº Doc:</label>
                                <div class="col-sm-4">
                                    <input name="nro_doc" type="text" autocomplete="off" class="form-control" placeholder="Número de documento" title="Número de documento">
                                </div>
                                <!-- <label for="nivelAlumno" class="col-sm-2 control-label">* Nivel: </label>
                                <div class="col-sm-4">
                                    <select name="nivelAlumno" class="form-control" onchange="if(this.options[1].selected) secundaria()" title="Nivel de estudios">
                                        <option value="1">Secundaria</option>
                                    </select>
                                </div>-->
                            </div>

                          

                            <div class="form-group">
                                <label for="direccionAlumno" class="col-sm-2 control-label">*Dirección:</label>
                                <div class="col-sm-10">
                                    <input name="direccion" type="text" autocomplete="off" class="form-control" placeholder="Direccion del alumno" title="Dirección del alumno">
                                </div>

                               
                            </div>

                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i> Registrar</button>
                                <a class="btn btn-default" data-dismiss="modal"><i class="fa fa-close" aria-hidden="true"></i> Cerrar</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/bootstrap.min.js"></script>

        <script src="js/app.min.js"></script>
    </div>

</body>

</html>
