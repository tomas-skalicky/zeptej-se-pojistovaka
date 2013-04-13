<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="cs">
<head>
<meta charset="UTF-8" />
<title>Zeptej se Pojišťováka</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen" />
</head>

<body>
    <div class="container">
        <div class="row-fluid">

            <!-- Introduction video -->
            <div class="span7">
                <video width="320" height="240" controls>
                    <source src="movie.mp4" type="video/mp4"></source>
                    <source src="movie.ogg" type="video/ogg"></source>
                    Your browser does not support the video tag.
                </video>
            </div>

            <!-- Form for access to the private section -->
            <div class="span5"></div>
        </div>

        <div class="row-fluid">fb like</div>

        <div class="row-fluid">

            <!-- Questions and Answers -->
            <div class="span7">
                <section id="questionsAndAnswers">
                    Máš dotaz?

                    <div class="pagination pagination-centered">
                        <ul>
                            <li class="disabled"><a href="#">&laquo;</a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div>
                </section>
            </div>

            <!-- Themas and Facebook like -->
            <div class="span5">
                <aside id="themas">
                    <div class="btn-group">
                        <button class="btn" type="button">
                            <i class="icon-home"></i> pojištění Bytové jednotky
                        </button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">
                            <i class="icon-home"></i> pojištění Domácnosti
                        </button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">Důchodové pojištění</button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-large" type="button">
                            <i class="icon-road"></i> Havarijní pojištění
                        </button>
                        <button class="btn btn-large" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">pojištění Na dožití</button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">
                            <i class="icon-heart"></i> Nemocenské pojištění
                        </button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">pojištění Odpovědnosti za škodu</button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn" type="button">Penzijní připojištění</button>
                        <button class="btn" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-large" type="button">
                            <i class="icon-road"></i> Povinné ručení
                        </button>
                        <button class="btn btn-large" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-mini" type="button">pojištění Proti odcizení</button>
                        <button class="btn btn-mini" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-mini" type="button">
                            <i class="icon-briefcase"></i> Spoření
                        </button>
                        <button class="btn btn-mini" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-success" type="button" data-toggle="tooltip" title="Blbostka">
                            <i class="icon-heart"></i> Úrazové pojištění
                        </button>
                        <button class="btn btn-success" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-small" type="button">
                            <i class="icon-fire"></i> Živelné pojištění
                        </button>
                        <button class="btn btn-small" type="button">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <div class="row-fluid">
                        <div class="input-append" id="addThema">
                            <input class="span12" type="text" placeholder="Nový typ pojištění" />
                            <button class="btn" type="button">
                                <i class="icon-plus"></i> Přidat
                            </button>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="lib/js/zeptejsepojistovaka-themas.js"></script>
</body>
</html>
