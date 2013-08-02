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
<link href="bootstrap/glyphicons-gh-pages/css/bootstrap-glyphicons.css" rel="stylesheet" media="screen" />

<!-- custom styles -->
<link href="lib/css/zeptejsepojistovaka.css" rel="stylesheet" media="screen" />
</head>

<body>
    <div class="container">
        <div class="row">

            <!-- Introduction video -->
            <div class="col-12 col-lg-7">
                <div id="header-video-wrapper" class="color-container white-container">
                    <iframe class="header-video-size"
                        src="http://www.youtube.com/embed/jQBFF54eU_k?feature=player_detailpage&autohide=1&showinfo=0&controls=1&modestbranding=0"
                        frameborder="0" allowfullscreen></iframe>
                </div>
            </div>


            <!-- Form for access to the private section -->
            <div class="col-12 col-lg-5">
                <div id="introduction-wrapper" class="color-container white-container">
                    <div class="row">
                        <div class="col-12">
                            <h2 class="right-header dark-grey-container">slovo autora</h2>
                            <blockquote class="pull-right">
                                <div>
                                    Dobrý den, jmenuji se Marie Skalická a pracuji jako pojišťovák již více jak 10 let. Máte-li otázku ze
                                    světa pojištění, ráda ji zodpovím. Nechcete-li otázku vkládat na tento web, můžete ji položit třeba <a
                                        href="#contact-modal" role="button" data-toggle="modal" class="show-contact">telefonicky</a>.
                                </div>
                                <small>Marie Skalická</small>
                            </blockquote>
                            <div class="pr-links">
                                <div class="fb-like" data-href="http://developers.facebook.com/docs/reference/plugins/like"
                                    data-send="false" data-layout="button_count" data-width="600" data-show-faces="true"></div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <div id="contents-wrapper" class="color-container white-container">
                    <div class="row">

                        <!-- Questions and Answers -->
                        <section id="questions-and-answers" class="col-12 col-sm-7">
                            <h3 class="left-header dark-grey-container">otázky & odpovědi</h3>
                            <div id="ask-question-bar">
                                <button class="btn btn-link btn-large" type="button">Položit otázku</button>
                                <div class="clear"></div>
                            </div>

                            <div id="ask-question" class="placeholder hide"></div>

                            <div id="existing-questions">
                                <div class="row">
                                    <div class="col-12">
                                        <article>
                                            <section class="question">
                                                <input name="question-id" type="hidden" value="20" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png" class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="question-thema">Popover top</span><span class="controls"> <span
                                                                class="glyphicon glyphicon-pencil edit" data-toggle="tooltip"
                                                                title="Upravit"></span> <a href="#delete-modal" role="button"
                                                                data-toggle="modal" class="delete"><span
                                                                    class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="question-text">
                                                                Popover top Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                                                Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere
                                                                consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem
                                                                lacinia quam venenatis vestibulum.<br /> <br /> Sed posuere consectetur
                                                                est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name">Anonym</span> <span class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                                                value='1374346915000' /><span class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answer-id" type="hidden" value="21" /> <img src="images/panacek-uvod.jpg"
                                                    class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answer-text">
                                                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                                                ornare sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur
                                                                est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name"><a href="#contact-modal" data-toggle="modal"
                                                                class="show-contact">Marie Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creation-timestamp' type='hidden' value='1374346944000' /><span
                                                                class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answer-id" type="hidden" value="22" /> <img src="images/panacek-uvod.jpg"
                                                    class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answer-text">Sed posuere consectetur est at lobortis. Aenean
                                                                eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</div>
                                                            <span class="controls"><span class="glyphicon glyphicon-pencil edit"
                                                                data-toggle="tooltip" title="Upravit"></span><a href="#delete-modal"
                                                                role="button" data-toggle="modal" class="delete"><span
                                                                    class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name"><a href="#contact-modal" data-toggle="modal"
                                                                class="show-contact">Marie Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creation-timestamp' type='hidden' value='1374346953000' /><span
                                                                class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="question-id" type="hidden" value="15" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png" class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="question-thema">Popover top</span><span class="controls"><span
                                                                class="glyphicon glyphicon-pencil edit" data-toggle="tooltip"
                                                                title="Upravit"></span><a href="#delete-modal" role="button"
                                                                data-toggle="modal" class="delete"><span
                                                                    class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="question-text">
                                                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                                                ornare sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur
                                                                est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name">Tom</span> <span class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                                                value='1374296515000' /><span class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="question-id" type="hidden" value="10" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png" class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="question-thema">Popover top</span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="question-text">Sed posuere consectetur est at lobortis. Aenean
                                                                eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name">Anonym</span> <span class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                                                value='1374271315000' /><span class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answer-id" type="hidden" value="11" /> <img src="images/panacek-uvod.jpg"
                                                    class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answer-text">Sed posuere consectetur est at lobortis. Aenean
                                                                eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name"><a href="#contact-modal" data-toggle="modal"
                                                                class="show-contact">Marie Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creation-timestamp' type='hidden' value='1374271855000' /><span
                                                                class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>

                                        <article>
                                            <section class="question">
                                                <input name="question-id" type="hidden" value="5" /> <img
                                                    src="images/1233576218_panacek-png_67x100.png" class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">
                                                            <span class="question-thema">Popover top</span><span class="controls"><span
                                                                class="glyphicon glyphicon-pencil edit" data-toggle="tooltip"
                                                                title="Upravit"></span><a href="#delete-modal" role="button"
                                                                data-toggle="modal" class="delete"><span
                                                                    class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                                        </h3>
                                                        <div class="popover-content">
                                                            <div class="question-text">
                                                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                                                ornare sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur
                                                                est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name">Julie</span> <span class="dot">·</span>
                                                            <button class="answer btn btn-link" type="button">Odpovědět</button>
                                                            <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                                                value='1374235855000' /><span class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                            <section class="answer">
                                                <input name="answer-id" type="hidden" value="6" /> <img src="images/panacek-uvod.jpg"
                                                    class="figure-image" alt="" />
                                                <div class="popover-wrapper">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <div class="popover-content">
                                                            <div class="answer-text">
                                                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                                                ornare sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur
                                                                est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                                                venenatis vestibulum.
                                                            </div>
                                                            <span class="controls"><span class="glyphicon glyphicon-pencil edit"
                                                                data-toggle="tooltip" title="Upravit"></span><a href="#delete-modal"
                                                                data-toggle="modal" class="delete"><span
                                                                    class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="author-name"><a href="#contact-modal" data-toggle="modal"
                                                                class="show-contact">Marie Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creation-timestamp' type='hidden' value='1332413882588' /><span
                                                                class="time continuously-updated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row loadNextWrapper">
                                    <div class="col-12">
                                        <button class="btn btn-link btn-small">Načíst další...</button>
                                    </div>
                                </div>
                            </div>
                        </section>

                        <!-- Filters and Facebook comments -->
                        <div class="col-12 col-sm-5">
                            <aside id="filters">
                                <header>
                                    <h4 class="right-header dark-grey-container">filtry</h4>
                                </header>
                                <div class="deactivate-filter">
                                    <button class="btn btn-link btn-large">Deaktivovat filter</button>
                                    <div class="clear"></div>
                                </div>
                                <div class="filter-list">
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="8" /><span class="glyphicon glyphicon-home"></span> <span class="filter-name">pojištění
                                                Bytové jednotky</span></a><a href="#delete-modal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                                            class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="9" /><span class="glyphicon glyphicon-home"></span> <span class="filter-name">pojištění
                                                Domácnosti</span></a><a href="#delete-modal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip" title="Smazat"
                                            class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="10" /><span class="filter-name">Důchodové pojištění</span></a><a href="#delete-modal"
                                            role="button" data-toggle="modal" class="btn btn-link delete"><span data-toggle="tooltip"
                                            title="Smazat" class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-large filter-label" type="button"><input name="filter-id"
                                            type="hidden" value="11" /><span class="glyphicon glyphicon-road"></span> <span
                                            class="filter-name">Havarijní pojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="12" /><span class="filter-name">pojištění Na dožití</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="13" /><span class="glyphicon glyphicon-heart"></span> <span class="filter-name">Nemocenské
                                                pojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="14" /><span class="filter-name">pojištění Odpovědnosti za škodu</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input name="filter-id" type="hidden"
                                            value="15" /><span class="filter-name">Penzijní připojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-large filter-label" type="button"><input name="filter-id"
                                            type="hidden" value="16" /><span class="glyphicon glyphicon-road"></span> <span
                                            class="filter-name">Povinné ručení</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-mini filter-label" type="button"><input name="filter-id"
                                            type="hidden" value="17" /><span class="filter-name">pojištění Proti odcizení</span> </a><a
                                            href="#delete-modal" role="button" data-toggle="modal" class="btn btn-link btn-mini delete"><span
                                            data-toggle="tooltip" title="Smazat" class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-mini filter-label" type="button"><input name="filter-id"
                                            type="hidden" value="18" /><span class="glyphicon glyphicon-briefcase"></span> <span
                                            class="filter-name">Spoření</span> </a><a href="#delete-modal" role="button" data-toggle="modal"
                                            class="btn btn-link btn-mini delete"><span data-toggle="tooltip" title="Smazat"
                                            class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-success filter-label selected-filter" type="button"><input name="filter-id"
                                            type="hidden" value="19" /><span class="glyphicon glyphicon-heart"></span> <span
                                            class="filter-name">Úrazové pojištění</span></a><a href="#delete-modal" role="button"
                                            data-toggle="modal" class="btn delete selected-filter"><span data-toggle="tooltip"
                                            title="Smazat" class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-small filter-label" type="button"><input name="filter-id"
                                            type="hidden" value="20" /><span class="glyphicon glyphicon-fire"></span> <span
                                            class="filter-name">Živelné pojištění</span></a><a href="#delete-modal" role="button"
                                            data-toggle="modal" class="btn btn-link btn-small delete"><span data-toggle="tooltip"
                                            title="Smazat" class="glyphicon glyphicon-remove" data-container="body"></span></a>
                                    </div>
                                </div>
                                <footer>
                                    <div class="input-group" id="add-filter">
                                        <span data-toggle="tooltip" title="Název nového filtru" data-placement="top"><input
                                            name="filter-name" type="text" placeholder="Název nového filtru..." class="form-control" /></span> <span
                                            class="input-group-btn">
                                            <button class="btn btn-info" type="button" data-toggle="tooltip" title="Přidat"
                                                data-container="body">
                                                <span class="glyphicon glyphicon-plus"></span>
                                            </button>
                                        </span>
                                    </div>
                                </footer>
                            </aside>

                            <aside id="facebook-comments">
                                <h4 class="right-header dark-grey-container">facebook</h4>
                                <div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="fb-comments" data-href="http://example.com" data-num-posts="8"></div>
                                        </div>
                                    </div>
                                </div>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="row">
            <div class="col-12 col-lg-6 col-offset-3">
                <div class="text-center page-footer color-container dark-grey-container">
                    <p>
                        <button class="btn btn-link show-data-protection" type="button" data-toggle="modal"
                            data-target="#data-protection-modal">Ochrana údajů</button>
                        |
                        <button class="btn btn-link show-contact" type="button" data-toggle="modal" data-target="#contact-modal">Kontakt</button>
                        |
                        <button class="btn btn-link show-cv" type="button" data-toggle="modal" data-target="#cv-modal">Můj
                            životopis</button>
                    </p>
                    <p>&copy; 2013 Marie Skalická</p>
                </div>
            </div>
        </footer>
    </div>


    <!-- Modals -->
    <div id="delete-modal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <input name="item-to-be-deleted-id" type="hidden" />
                <div class="modal-body">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title confirmation-question"></h4>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-info delete">Smazat</button>
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Zrušit</button>
                </div>
            </div>
        </div>
    </div>
    <div id="data-protection-modal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">Ochrana údajů</h3>
                </div>
                <div class="modal-body">
                    <p>
                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                        vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                        venenatis vestibulum.
                    </p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
                </div>
            </div>
        </div>
    </div>
    <div id="contact-modal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">Kontakt</h3>
                </div>
                <div class="modal-body">
                    <section class="contacts">
                        <div class="contact-list">
                            <h4>Marie Skalická</h4>
                            <p>
                                +420 721 949 024<br /> <a href="#" class="email">mskalickadoma@gmail.com</a>
                            </p>
                            <p>Osobní schůzka je možná po předchozí domluvě.</p>
                        </div>
                    </section>
                    <section class="message-form">
                        <h4>Napiště mi</h4>
                        <div class="row">
                            <div class="col-12">
                                <div class="question">
                                    <img src="images/1233576218_panacek-png_67x100.png" class="figure-image" alt="" />
                                    <div class='popover-wrapper'>
                                        <div class="popover right">
                                            <div class="arrow"></div>
                                            <div class="popover-title">
                                                <span data-toggle="tooltip" title="Váš e-mail" data-placement='right'
                                                    data-trigger='click hover focus manual'><input name="author-email" type="text"
                                                    placeholder="Váš e-mail..." /></span><span data-toggle="tooltip" title="Vaše jméno"
                                                    data-placement='right' data-trigger='click hover focus manual'><input
                                                    name="author-name" type="text" placeholder="Vaše jméno... (nepovinné)" /></span><span
                                                    data-toggle="tooltip" title="Předmět vzkazu" data-placement='right'
                                                    data-trigger='click hover focus manual'><select name="message-thema"><option
                                                            value=""></option>
                                                        <option value="technical-problem">Technický problém</option>
                                                        <option value="other">Ostatní</option></select></span>
                                            </div>
                                            <div class="popover-content">
                                                <span data-toggle="tooltip" title="Text vzkazu" data-placement="right"
                                                    data-trigger='click hover focus manual'><textarea name="message-text"
                                                        placeholder="Text vzkazu..."></textarea></span>
                                            </div>
                                        </div>
                                        <button class='btn btn-info submit' type='button'>Odeslat</button>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="who-is">
                        <h4>Kdo je Marie Skalická?</h4>
                        <div class="row">
                            <div class="col-8 text">
                                <p>
                                    Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                    venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                    ornare sem lacinia quam venenatis vestibulum.
                                </p>
                                <p>
                                    Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                    venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                    ornare sem lacinia quam venenatis vestibulum.
                                </p>
                                <p>
                                    Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                    venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                    ornare sem lacinia quam venenatis vestibulum.
                                </p>
                            </div>
                            <p class="col-4">
                                <img src="images/passportPhoto.png" class="passport-photo" />
                            </p>
                            <div class="clear"></div>
                        </div>
                    </section>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
                </div>
            </div>
        </div>
    </div>
    <div id="cv-modal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title">Můj životopis</h3>
                </div>
                <div class="modal-body">
                    <p>
                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                        vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                        venenatis vestibulum.
                    </p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
                </div>
            </div>
        </div>
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery/jquery-1.9.1.min.js"></script>
    <script src="jquery/jquery.dateFormat-1.0.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- Optionally enable responsive features in IE8 -->
    <script src="bootstrap/js/respond.min.js"></script>

    <script src="lib/js/zeptejsepojistovaka-bootstrap.js"></script>
    <script src="lib/js/zeptejsepojistovaka-String.js"></script>
    <script src="lib/js/zeptejsepojistovaka-utils.js"></script>
    <script src="lib/js/zeptejsepojistovaka-tooltip.js"></script>
    <script src="lib/js/zeptejsepojistovaka-introduction.js"></script>
    <script src="lib/js/zeptejsepojistovaka-filters.js"></script>
    <script src="lib/js/zeptejsepojistovaka-questionsAndAnswers.js"></script>
    <script src="lib/js/zeptejsepojistovaka-time.js"></script>
    <script src="lib/js/zeptejsepojistovaka-contact.js"></script>

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
