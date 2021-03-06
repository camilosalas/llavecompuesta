<%-- 
    Document   : header
    Created on : 04/06/2017, 08:10:26 AM
    Author     : Jeison E. Sanchez C
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarioSesion" scope="session" class="java.lang.String"/>

<header class="main-header">
    <!-- Logo -->
    <a href="inicio.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>BI</b>BL</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>BIBLIOTECA </b> OFELIA</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><%= usuarioSesion%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                <%= usuarioSesion%> - ADMIN
                                <small>OFELIA VELASQUEZ</small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Perfil</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">Salir</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
