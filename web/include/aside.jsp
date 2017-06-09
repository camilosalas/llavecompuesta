            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p><%= usuarioSesion %> - Admin</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Conectado</a>
                        </div>
                    </div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">MENÚ - PRINCIPAL</li>
                        <li>
                            <a href="inicio.html">
                                <i class="glyphicon glyphicon-home"></i> <span>Página Principal</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="glyphicon glyphicon-edit"></i>
                                <span>Registro</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href=""><i class="fa fa-book"></i>Libro</a></li>
                            </ul>
                            <ul class="treeview-menu">
                                <li><a href="ListarAlumno"><i class="fa fa-users"></i>Alumno</a></li>
                            </ul>
                            <ul class="treeview-menu">
                                <li><a href="ListarPersona"><i class="fa fa-circle-o"></i>Docente</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="listarLector">
                            <i class="glyphicon glyphicon-book"></i>Lectores
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="">
                                <i class="glyphicon glyphicon-edit"></i>
                                <span>Prestamo</span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
