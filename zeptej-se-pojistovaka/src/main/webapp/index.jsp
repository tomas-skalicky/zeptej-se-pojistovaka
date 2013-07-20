<%@ page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="cs">
<head>
<meta charset="UTF-8" />
<title>Zeptej se Pojišťováka</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen" />

<!-- custom styles -->
<link href="lib/css/zeptejsepojistovaka.css" rel="stylesheet" media="screen" />
</head>

<body>
    <input id="contactPageUrl" type="hidden" value="<c:url value="/kontakt" />" />

    <div class="container">
        <div class="row-fluid">

            <!-- Introduction video -->
            <div class="span7">
                <div id="header-video-wrapper" class="color-container white-container header-video-size">
                    <iframe class="header-video-size"
                        src="http://www.youtube.com/embed/HItlmCjkJ1c?feature=player_detailpage&autohide=1&showinfo=0&controls=1&modestbranding=0"
                        frameborder="0" allowfullscreen></iframe>
                </div>
            </div>


            <!-- Form for access to the private section -->
            <div id="introduction-wrapper" class="span5 color-container white-container">
                <h2 class="right-header dark-grey-container">
                    <span></span> slov autora
                </h2>
                <blockquote class="pull-right">
                    <div>
                        Dobrý den, jmenuji se Marie Skalická a pracuji jako pojišťovák již více jak 10 let.
                        Máš-li otázku ze světa pojištění, ráda ji zodpovím. Nechceš-li otázku vkládat na tento
                        web, můžeš ji položit třeba <a href="<c:url value="/kontakt" />">telefonicky</a>.
                    </div>
                    <small>Marie Skalická</small>
                </blockquote>
            </div>
        </div>

        <div id="action-bar">
            <div class="row-fluid">
                <div class="fb-like" data-href="http://developers.facebook.com/docs/reference/plugins/like"
                    data-send="false" data-layout="button_count" data-width="600" data-show-faces="true"></div>
            </div>
        </div>

        <div id="contents-wrapper" class="color-container white-container">
            <div class="row-fluid">

                <!-- Questions and Answers -->
                <div class="span7">
                    <section id="questionsAndAnswers">
                        <h3 class="left-header dark-grey-container">Otázky & Odpovědi</h3>
                        <div id="askQuestionBar">
                            <button class="btn btn-link btn-large" type="button">Položit otázku</button>
                        </div>

                        <div id="askQuestion" class="placeholder hide"></div>

                        <div id="existingQuestions">
                            <div>
                                <div class="row-fluid">
                                    <div class="span12">
                                        <article>
                                            <section class="question">
                                                <input name="questionId" type="hidden" value="20" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png"
                                                    class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="questionThema">Popover top</span><span
                                                                class="controls"><i
                                                                class="icon-pencil icon-white edit"
                                                                data-toggle="tooltip" title="Upravit"></i><i
                                                                class="icon-remove icon-white delete"
                                                                data-toggle="tooltip" title="Vymazat"></i></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="questionText">
                                                                Popover top Sed posuere consectetur est at
                                                                lobortis. Aenean eu leo quam. Pellentesque
                                                                ornare sem lacinia quam venenatis vestibulum.
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> <br />
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName">Anonym</span> <span
                                                                class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374346915000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answerId" type="hidden" value="21" /> <img
                                                    src="images/panacek-uvod.jpg" class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answerText">
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> Sed
                                                                posuere consectetur est at lobortis. Aenean eu
                                                                leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="<c:url value="/kontakt" />">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374346944000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answerId" type="hidden" value="22" /> <img
                                                    src="images/panacek-uvod.jpg" class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answerText">Sed posuere
                                                                consectetur est at lobortis. Aenean eu leo
                                                                quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.</div>
                                                            <span class="controls"><i
                                                                class="icon-pencil icon-white edit"
                                                                data-toggle="tooltip" title="Upravit"></i><i
                                                                class="icon-remove icon-white delete"
                                                                data-toggle="tooltip" title="Vymazat"></i></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="<c:url value="/kontakt" />">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374346953000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="questionId" type="hidden" value="15" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png"
                                                    class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="questionThema">Popover top</span><span
                                                                class="controls"><i
                                                                class="icon-pencil icon-white edit"
                                                                data-toggle="tooltip" title="Upravit"></i><i
                                                                class="icon-remove icon-white delete"
                                                                data-toggle="tooltip" title="Vymazat"></i></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="questionText">
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> Sed
                                                                posuere consectetur est at lobortis. Aenean eu
                                                                leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName">Tom</span> <span
                                                                class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374296515000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="questionId" type="hidden" value="10" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png"
                                                    class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="questionThema">Popover top</span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="questionText">Sed posuere
                                                                consectetur est at lobortis. Aenean eu leo
                                                                quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.</div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName">Anonym</span> <span
                                                                class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374271315000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answerId" type="hidden" value="11" /> <img
                                                    src="images/panacek-uvod.jpg" class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answerText">Sed posuere
                                                                consectetur est at lobortis. Aenean eu leo
                                                                quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.</div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="<c:url value="/kontakt" />">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374271855000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="questionId" type="hidden" value="5" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png"
                                                    class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="questionThema">Popover top</span><span
                                                                class="controls"><i
                                                                class="icon-pencil icon-white edit"
                                                                data-toggle="tooltip" title="Upravit"></i><i
                                                                class="icon-remove icon-white delete"
                                                                data-toggle="tooltip" title="Vymazat"></i></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="questionText">
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> Sed
                                                                posuere consectetur est at lobortis. Aenean eu
                                                                leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName">Julie</span> <span
                                                                class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1374235855000' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answerId" type="hidden" value="6" /> <img
                                                    src="images/panacek-uvod.jpg" class="figure" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answerText">
                                                                Sed posuere consectetur est at lobortis.
                                                                Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> Sed
                                                                posuere consectetur est at lobortis. Aenean eu
                                                                leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                            <span class="controls"><i
                                                                class="icon-pencil icon-white edit"
                                                                data-toggle="tooltip" title="Upravit"></i><i
                                                                class="icon-remove icon-white delete"
                                                                data-toggle="tooltip" title="Vymazat"></i></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="<c:url value="/kontakt" />">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden' value='1332413882588' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <div class="pagination pagination-centered">
                                            <ul>
                                                <li class="disabled"><a href="#">&laquo;</a></li>
                                                <li class="active"><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                                <li><a href="#">&raquo;</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>

                <!-- Themas and Facebook comments -->
                <div class="span5">
                    <aside id="themas">
                        <h4 class="right-header dark-grey-container">Filtry</h4>
                        <div>
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-home"></i> pojištění Bytové jednotky
                                        </button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-home"></i> pojištění Domácnosti
                                        </button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">Důchodové
                                            pojištění</button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link btn-large" type="button">
                                            <i class="icon-road"></i> Havarijní pojištění
                                        </button>
                                        <button class="btn btn-link btn-large" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">pojištění Na
                                            dožití</button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-heart"></i> Nemocenské pojištění
                                        </button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">pojištění
                                            Odpovědnosti za škodu</button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link" type="button">Penzijní
                                            připojištění</button>
                                        <button class="btn btn-link" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link btn-large" type="button">
                                            <i class="icon-road"></i> Povinné ručení
                                        </button>
                                        <button class="btn btn-link btn-large" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link btn-mini" type="button">pojištění
                                            Proti odcizení</button>
                                        <button class="btn btn-link btn-mini" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link btn-mini" type="button">
                                            <i class="icon-briefcase"></i> Spoření
                                        </button>
                                        <button class="btn btn-link btn-mini" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-success" type="button" data-toggle="tooltip"
                                            title="Blbostka">
                                            <i class="icon-heart"></i> Úrazové pojištění
                                        </button>
                                        <button class="btn btn-success" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn btn-link btn-small" type="button">
                                            <i class="icon-fire"></i> Živelné pojištění
                                        </button>
                                        <button class="btn btn-link btn-small" type="button">
                                            <i class="icon-remove"></i>
                                        </button>
                                    </div>
                                    <div class="row-fluid">
                                        <div class="input-append" id="addThema">
                                            <input type="text" placeholder="Nový typ pojištění" />
                                            <button class="btn" type="button">
                                                <i class="icon-plus"></i> Přidat
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </aside>

                    <aside id="facebook-comments">
                        <h4 class="right-header dark-grey-container">facebook</h4>
                        <div>
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="fb-comments" data-href="http://example.com" data-num-posts="8"></div>
                                </div>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
        </div>

        <footer class="row-fluid">
            <div class="span6 offset3 text-center page-footer color-container dark-grey-container">
                <p>
                    <button class="btn btn-link btn-large" type="button">Kontakt</button>
                    |
                    <button class="btn btn-link btn-large" type="button">Můj životopis</button>
                </p>
                <p>&copy; 2013 Marie Skalická</p>
            </div>
        </footer>
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery/jquery-1.9.1.min.js"></script>
    <script src="jquery/jquery.dateFormat-1.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="lib/js/zeptejsepojistovaka-String.js"></script>
    <script src="lib/js/zeptejsepojistovaka-utils.js"></script>
    <script src="lib/js/zeptejsepojistovaka-introduction.js"></script>
    <script src="lib/js/zeptejsepojistovaka-themas.js"></script>
    <script src="lib/js/zeptejsepojistovaka-questionsAndAnswers.js"></script>
    <script src="lib/js/zeptejsepojistovaka-time.js"></script>

    <!-- Facebook JavaScript SDK activation -->
    <div id="fb-root"></div>
    <script>
					(function(d, s, id) {
						var js, fjs = d.getElementsByTagName(s)[0];
						if (d.getElementById(id))
							return;
						js = d.createElement(s);
						js.id = id;
						js.src = "//connect.facebook.net/cs_CZ/all.js#xfbml=1";
						fjs.parentNode.insertBefore(js, fjs);
					}(document, 'script', 'facebook-jssdk'));
				</script>
</body>
</html>
