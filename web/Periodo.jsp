<%-- 
    Document   : Periodo
    Created on : 04/06/2017, 11:33:58 AM
    Author     : FIORELLA S
--%>
<%@page import="ofelia.controller.ListarPeriodo"%>
<%@page import="ofelia.model.entity.Periodo" %>
<%@page import="java.util.List" %>
<%@page import="ofelia.model.dao.PeriodoDAO" %>
<%@page import="ofelia.model.dao.impl.PeriodoDaoImpl" %>
<jsp:useBean id="ListarPeriodo" scope= "request" type="java.util.List<Periodo>"/>
<!DOCTYPE html>
<html>

    <%@include file="include/head.jsp" %>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <%@include file="include/header.jsp" %>

            <%@include file="include/aside.jsp" %>

            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        MÓDULO REGISTRO
                        <small>Registrar Periodo</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href=""><i class="glyphicon glyphicon-home"></i> Inicio</a></li>
                        <li class="active">Mantenimiento</li>
                        <li class="active">Registrar Periodo</li>
                    </ol>
                </section>

                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn btn-primary" data-toggle="modal" data-target="#addDocente">
                                <i class="ion-person-add"></i> Registrar Periodo</button>
                            <a class="btn btn-primary" href="ListarPeriodo"><i class="glyphicon glyphicon-refresh"></i> Actualizar</a>
                        </div>

                    </div>

                    <section class="content">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="box collapsed-box">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Registro de Periodo</h3>
                                        <div class="box-tools pull-right">
                                        </div>
                                    </div>
                                    <div class="">
                                        <div class="container-fluid">
                                            <div class="col-lg-12">
                                                <div class="table-responsive">
                                                    <table id="tablaPeriodo" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                                                        <thead>
                                                            <tr role="row">
                                                                <th>
                                                        <center>#</center>
                                                        </th>
                                                        <th>
                                                        <center>Periodo</center>
                                                        </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                int contador1 = 0;
                                                                for (Periodo p : ListarPeriodo) {
                                                                    contador1++;
                                                            %>
                                                            <tr role="row" class="odd">
                                                                <td class="sorting_1"><%= contador1%></td>
                                                                <td><%= p.getPeriodo()%></td>
                                                                <td>
                                                        <center>
                                                            <a class="btn btn-warning btn-xs" data-toggle="modal" data-target="#editar<%=contador1%>" ><i class="fa fa-pencil" aria-hidden="true"></i> </a>
                                                            <a class="btn btn-danger btn-xs" href="ControlPeriodo?op=delete_periodo&idperiodo=<%=p.getIdperiodo()%>" role="button"><i class="fa fa-trash" aria-hidden="true"></i> </a>
                                                            <div class="modal fade" id="editar<%=contador1%>" tabindex="-1" role="dialog">
                                                                <div class="modal-dialog" role="document">
                                                                    <div class="modal-content">

                                                                        <div class="modal-header">
                                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                            <h4 class="modal-title"><i class="ion-person-add"></i> Actualizar Periodo</h4>
                                                                        </div>

                                                                        <div class="modal-body">
                                                                            <form action="ControlPeriodo" method="post" class="form-horizontal">
                                                                                <input type="hidden" name="op" value="update_periodo">
                                                                                <input type="hidden" name="idperiodo" value="<%=p.getIdperiodo()%>">

                                                                                <div class="form-group">
                                                                                    <label for="nombrePeriodo" class="col-sm-2 control-label">* Nombre:</label>
                                                                                    <div class="col-sm-4">
                                                                                        <input name="periodo" type="text" autocomplete="off" class="form-control" value="<%=p.getPeriodo()%>">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="modal-footer">
                                                                                    <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i> Actualizar</button>
                                                                                    <a class="btn btn-default" data-dismiss="modal"><i class="fa fa-close" aria-hidden="true"></i> Cerrar</a>
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
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
                    </section>
                </section>
            </div>


            <div class="modal fade" id="addDocente" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><i class="ion-person-add"></i> Agregar Periodo</h4>
                        </div>

                        <div class="modal-body">

                            <form action="ControlPeriodo" method="post" class="form-horizontal">

                                <input type="hidden" name="op" value="add_periodo">
                                <div class="row">
                                    <div class="col-lg-12">

                                        <div class="form-group col-md-12">

                                            <div class="form-group">
                                                <label for="nombrePeriodo" class="col-sm-2 control-label">*Periodo:</label>
                                                <div class="col-sm-4">
                                                    <input name="periodo" type="text" autocomplete="off" class="form-control" placeholder="Nombre del Periodo" title="Nombre del Periodo">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i> Registrar</button>
                                                <a class="btn btn-default" data-dismiss="modal"><i class="fa fa-close" aria-hidden="true"></i> Cerrar</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <div class="modal fade" id="" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><i class="ion-person-add"></i> Actualizar Periodo</h4>
                        </div>

                        <div class="modal-body">
                            <form action="ControlPeriodo" method="post" class="form-horizontal">
                                <input type="hidden" name="op" value="update_periodo">
                               
                                <div class="form-group">
                                    <label for="nombrePeriodo" class="col-sm-2 control-label">* Periodo:</label>
                                    <div class="col-sm-4">
                                        <input name="periodo" type="text" autocomplete="off" class="form-control" value="">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i> Actualizar</button>
                                    <a class="btn btn-default" data-dismiss="modal"><i class="fa fa-close" aria-hidden="true"></i> Cerrar</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <%@include file="include/footer.jsp" %>

            <!-- Bootstrap 3.3.6 -->
            <script src="js/bootstrap.min.js"></script>
            <!-- AdminLTE App -->
            <script src="js/app.min.js"></script>
        </div>

    </body>

</html>
