<%-- 
    Document   : Lectores
    Created on : 08/06/2017, 03:33:49 PM
    Author     : CamiloST
--%>

<%@page import="ofelia.model.entity.Periodo"%>
<%@page import="ofelia.model.entity.Lector"%>
<%@page import="ofelia.controller.ListarLector"%>
<%@page import="ofelia.model.entity.Persona"%>

<jsp:useBean id="ListarLector" scope="request" type="java.util.List<Lector>"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="include/head.jsp" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

        <%@include file="include/header.jsp" %>

        <%@include file="include/aside.jsp" %>


        <div class="content-wrapper">
            <section class="content-header">
                <h1 class="epic-nav-item-heading " aria-selected="true">
                    MÓDULO REGISTRO
                    <small>Registrar Lector</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="inicio.jsp"><i class="glyphicon glyphicon-home"></i> Inicio</a></li>
                    <li class="active">Registro</li>
                    <li class="active">Registrar Lector</li>
                </ol>
            </section>

            <section class="content">
                <div class="row">
                   
                    <div class="col-md-12">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#addLector">
                            <i class="ion-person-add"></i> Registrar Lector
                        </button>
                        <a href="listarLector" class="btn btn-primary">
                                <i class="glyphicon glyphicon-refresh"></i> Actualizar</a>
                        
                        <br><br>
                    </div>
                    
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="box collapsed-box">
                            <div class="box-header with-border">
                                <h3 class="box-title"> Registro de Lectores</h3>
                            </div>

                            <div class="">
                                <div class="row">
                                    <div class="container-fluid">
                                        
                                           <div class="col-lg-12">
                                            <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                                                <div class="table-responsive">
                                                    
                                                    <table align="center" id="tablaAlumnos" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                                                        <thead>
                                                            <tr role="row"class="odd">
                                                                <th>Periodo</th>
                                                                <th>Persona</th>
                                                                <th>Turno</th>
                                                                <th>Tipo</th>
                                                                <th>Estado Habilitado</th>
                                                                <th>Nivel</th> 
                                                                <th>Grado</th>                                                               
                                                                <th>Sección</th>
                                                                <th>Condición</th>
                                                                <th>Opcion</th>
                                                            </tr>
                                                        </thead>

                                                            <%
                                                                
                                                             int contador1 = 0;
                                                             for (Lector l : ListarLector) {
                                                             contador1++;
                                                           %>

                                                           <tr role="row" class="odd">
                                                                
                                                                <td><%= l.getIdperiodo() %></td>
                                                                <td><%= l.getIdpersona() %></td>
                                                                <td><% if(l.getIdturno()==1){
                                                                    out.write("mañana");
                                                                }
                                                                if(l.getIdturno()==2){
                                                                    out.write("tarde");
                                                                
                                                                }
                                                                if(l.getIdturno()==3){
                                                                    out.write("noche");
                                                                
                                                                }%></td>
                                                                <td><%
                                                                        if (l.getIdtipo()== 1){
                                                                                out.write("estudiante");
                                                                            }
                                                                            if (l.getIdtipo() == 2) {
                                                                                out.write("docente");
                                                                            }
                                                                            if(l.getIdtipo()==3){
                                                                                out.write("visitante");
                                                                            
                                                                            }
                                                                
                                                                    %></td>
                                                                <td><%
                                                                    if(l.getEstado_habil()==1){
                                                                        out.write("activo");
                                                                    
                                                                    }
                                                                    if(l.getEstado_habil()==2){
                                                                        out.write("desactivo");
                                                                    }
                                                                    %></td>
                                                                <td><%= l.getNivel()%></td>
                                                                <td><%= l.getGrado() %></td>
                                                                <td><%= l.getSeccion()%></td>
                                                                <td><%= l.getCondicion()%></td>
                                                                <td>
                                                                    <center>
                                                                        <a class="btn btn-warning btn-xs" href="#"><i class="fa fa-pencil" aria-hidden="true"></i> </a>
                                                                        <a class="btn btn-danger btn-xs" href="controlLector?op=delete_lector&idperiodo=<%=l.getIdperiodo()%>&idpersona=<%=l.getIdpersona()%>" role="button"><i class="fa fa-trash" aria-hidden="true"></i> </a>
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




        <div class="modal fade" id="addLector" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title"><i class="ion-person-add"></i> Agregar Lector</h4>
                    </div>

                    <div class="modal-body">
                        <!--<div class="alert alert-warning" role="alert" style="opacity: 1.5">
                            <strong style="color: #ffffff;"><i class="icon fa fa-warning"></i>Advertencia: </strong>Asegúrate de llenar todos los campos *
                        </div>-->
                        
                        

                        <form action="controlLector" method="post" class="form-horizontal">
                            <input type="hidden" name="op" value="add_Lector">

                            <div class="form-group">
                                <label for="" class="col-sm-2 control-label">* Periodo:</label>
                                <div class="col-sm-4">
                                    <input name="persona" type="text" autocomplete="off" class="form-control" placeholder="periodo" title="periodo">
                                </div>

                                <label for="" class="col-sm-2 control-label">* Persona: </label>
                                <div class="col-sm-4">
                                    <input name="persona" type="text" autocomplete="off" class="form-control" placeholder="periodo" title="periodo">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="turnoLector" class="col-sm-2 control-label">* Turno: </label>
                                <div class="col-sm-4">
                                    <select name="turno" class="form-control" title="Turno del lector">
                                      <option value="">Selecione su Turno</option>
                                       <option value="1">mañana</option>
                                       <option value="2">tarde</option>
                                        <option value="3">noche</option>
                                    </select>
                                </div>

                                <label for="tipoLector" class="col-sm-2 control-label">* Tipo: </label>
                                <div class="col-sm-4">
                                    <select name="tipo" class="form-control" title="Tipo del lector">
                                      <option value="">Selecione el Tipo</option>
                                       <option value="1">estudiante</option>
                                       <option value="2">docente</option>
                                        <option value="3">visitante</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="estadoLector" class="col-sm-2 control-label">* Estado Habilitado: </label>
                                <div class="col-sm-4">
                                    <select name="estadoo" class="form-control" title="Estado del lector">
                                      <option value="">Selecione el estado</option>
                                       <option value="1">activo</option>
                                       <option value="2">desactivo</option>
                                    </select>
                                </div>

                                <label for="nivelLector" class="col-sm-2 control-label">* Nivel: </label>
                                <div class="col-sm-4">
                                    <input name="nivel" type="text" autocomplete="off" class="form-control" placeholder="Nivel del lector" title="Nivel del lector">
                                </div>
                            </div>

                          

                            <div class="form-group">
                                <label for="gradoLector" class="col-sm-2 control-label">*Grado:</label>
                                <div class="col-sm-2">
                                    <input name="grado" type="text" autocomplete="off" class="form-control" placeholder="grado del lector" title="grado del lector">
                                </div>

                               <label for="seccionLector" class="col-sm-2 control-label">*Seccion</label>
                                <div class="col-sm-2">
                                    <input name="seccion" type="text" autocomplete="off" class="form-control" placeholder="seccion del lector" title="seccion del lector">
                                </div>
                               
                               <label for="condicionLector" class="col-sm-2 control-label">*Condicion</label>
                                <div class="col-sm-2">
                                    <input name="condicion" type="text" autocomplete="off" class="form-control" placeholder="condicion del lector" title="condicion del lector">
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
