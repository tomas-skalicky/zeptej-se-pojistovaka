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
                        Máte-li otázku ze světa pojištění, ráda ji zodpovím. Nechcete-li otázku vkládat na
                        tento web, můžete ji položit třeba <a href="#contactModal" role="button"
                            data-toggle="modal" class="showContact">telefonicky</a>.
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
                                                                data-toggle="tooltip" title="Upravit"></i><a
                                                                href="#deleteModal" role="button"
                                                                data-toggle="modal" class="delete"><i
                                                                    class="icon-remove icon-white"
                                                                    data-toggle="tooltip" title="Smazat"></i></a></span>
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
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374346915000' /><span
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
                                                                href="#contactModal" role="button"
                                                                data-toggle="modal" class="showContact">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374346944000' /><span
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
                                                                data-toggle="tooltip" title="Upravit"></i><a
                                                                href="#deleteModal" role="button"
                                                                data-toggle="modal" class="delete"><i
                                                                    class="icon-remove icon-white"
                                                                    data-toggle="tooltip" title="Smazat"></i></a></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="#contactModal" role="button"
                                                                data-toggle="modal" class="showContact">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374346953000' /><span
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
                                                                data-toggle="tooltip" title="Upravit"></i><a
                                                                href="#deleteModal" role="button"
                                                                data-toggle="modal" class="delete"><i
                                                                    class="icon-remove icon-white"
                                                                    data-toggle="tooltip" title="Smazat"></i></a></span>
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
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374296515000' /><span
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
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374271315000' /><span
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
                                                                href="#contactModal" role="button"
                                                                data-toggle="modal" class="showContact">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374271855000' /><span
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
                                                                data-toggle="tooltip" title="Upravit"></i><a
                                                                href="#deleteModal" role="button"
                                                                data-toggle="modal" class="delete"><i
                                                                    class="icon-remove icon-white"
                                                                    data-toggle="tooltip" title="Smazat"></i></a></span>
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
                                                                name='creationTimestamp' type='hidden'
                                                                value='1374235855000' /><span
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
                                                                data-toggle="tooltip" title="Upravit"></i><a
                                                                href="#deleteModal" role="button"
                                                                data-toggle="modal" class="delete"><i
                                                                    class="icon-remove icon-white"
                                                                    data-toggle="tooltip" title="Smazat"></i></a></span>
                                                        </div>
                                                        <div class="popover-footer grey">
                                                            <span class="authorName"><a
                                                                href="#contactModal" role="button"
                                                                data-toggle="modal" class="showContact">Marie
                                                                    Skalická</a></span> <span class="dot">·</span> <input
                                                                name='creationTimestamp' type='hidden'
                                                                value='1332413882588' /><span
                                                                class="time continuouslyUpdated"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="clear"></div>
                                            </section>
                                        </article>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>

                <!-- Filters and Facebook comments -->
                <div class="span5">
                    <aside id="filters">
                        <header>
                            <h4 class="right-header dark-grey-container">Filtry</h4>
                        </header>
                        <div class="deactivate-filter">
                            <div class="row-fluid">
                                <button class="btn btn-link btn-large">Deaktivovat filter</button>
                                <div class="clear"></div>
                            </div>
                        </div>
                        <div class="filter-list">
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="8" /><i class="icon-home"></i>
                                            <span class="filterName">pojištění Bytové jednotky</span></a><a
                                            href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip"
                                            title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="9" /><i class="icon-home"></i>
                                            <span class="filterName">pojištění Domácnosti</span></a><a
                                            href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip"
                                            title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="10" /><span
                                            class="filterName">Důchodové pojištění</span></a><a
                                            href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip"
                                            title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-large filter-label" type="button"><input
                                            name="filterId" type="hidden" value="11" /><i class="icon-road"></i>
                                            <span class="filterName">Havarijní pojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="12" /><span
                                            class="filterName">pojištění Na dožití</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="13" /><i class="icon-heart"></i>
                                            <span class="filterName">Nemocenské pojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="14" /><span
                                            class="filterName">pojištění Odpovědnosti za škodu</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link filter-label" type="button"><input
                                            name="filterId" type="hidden" value="15" /><span
                                            class="filterName">Penzijní připojištění</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-large filter-label" type="button"><input
                                            name="filterId" type="hidden" value="16" /><i class="icon-road"></i>
                                            <span class="filterName">Povinné ručení</span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-mini filter-label" type="button"><input
                                            name="filterId" type="hidden" value="17" /><span
                                            class="filterName">pojištění Proti odcizení</span> </a><a
                                            href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link btn-mini delete"><span
                                            data-toggle="tooltip" title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-mini filter-label" type="button"><input
                                            name="filterId" type="hidden" value="18" /><i
                                            class="icon-briefcase"></i> <span class="filterName">Spoření</span>
                                        </a><a href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link btn-mini delete"><span
                                            data-toggle="tooltip" title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-success filter-label" type="button"
                                            data-toggle="tooltip" title="Blbostka"><input name="filterId"
                                            type="hidden" value="19" /><i class="icon-heart"></i> <span
                                            class="filterName">Úrazové pojištění</span></a><a href="#deleteModal"
                                            role="button" data-toggle="modal" class="btn btn-success delete"><span
                                            data-toggle="tooltip" title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                    <div class="btn-group filter">
                                        <a class="btn btn-link btn-small filter-label" type="button"><input
                                            name="filterId" type="hidden" value="20" /><i class="icon-fire"></i>
                                            <span class="filterName">Živelné pojištění</span></a><a
                                            href="#deleteModal" role="button" data-toggle="modal"
                                            class="btn btn-link delete"><span data-toggle="tooltip"
                                            title="Smazat"><i class="icon-remove"></i></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <footer>
                            <div class="row-fluid">
                                <div class="input-append" id="addFilter">
                                    <input name="filterName" type="text" placeholder="Nový filter" />
                                    <button class="btn" type="button" data-toggle="tooltip" title="Přidat">
                                        <i class="icon-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </footer>
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
                    <a href="#dataProtectionModal" role="button" data-toggle="modal">
                        <button class="btn btn-link showDataProtection" type="button">Ochrana údajů</button>
                    </a> | <a href="#contactModal" role="button" data-toggle="modal">
                        <button class="btn btn-link showContact" type="button">Kontakt</button>
                    </a> | <a href="#cvModal" role="button" data-toggle="modal">
                        <button class="btn btn-link showCv" type="button">Můj životopis</button>
                    </a>
                </p>
                <p>&copy; 2013 Marie Skalická</p>
            </div>
        </footer>
    </div>


    <!-- Modals -->
    <div id="deleteModal" class="modal hide" tabindex="-1" role="dialog"
        aria-labelledby="deleteModalConfirmationQuestion" aria-hidden="true">
        <input name="itemToBeDeletedId" type="hidden" />
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 id="deleteModalConfirmationQuestion"></h4>
        </div>
        <div class="modal-footer">
            <button class="btn btn-info delete">Smazat</button>
            <button class="btn" data-dismiss="modal" aria-hidden="true">Zrušit</button>
        </div>
    </div>
    <div id="dataProtectionModal" class="modal hide no-max-height" tabindex="-1" role="dialog"
        aria-labelledby="dataProtectionModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="dataProtectionModalLabel">Ochrana údajů</h3>
        </div>
        <div class="modal-body">
            <p>
                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia
                quam venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                Pellentesque ornare sem lacinia quam venenatis vestibulum.
            </p>
        </div>
        <div class="modal-footer">
            <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
        </div>
    </div>
    <div id="contactModal" class="modal hide no-max-height" tabindex="-1" role="dialog"
        aria-labelledby="contactModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="contactModalLabel">Kontakt</h3>
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
            <section class="email-form">
                <h4>Napiště mi</h4>
                <div class="row-fluid">
                    <div class="question">
                        <img src="images/1233576218_panacek-png_67x100.png" class="figure" alt="" />
                        <div class='popover-wrapper'>
                            <div class="popover right">
                                <div class="arrow"></div>
                                <div class="popover-title">
                                    <input name="yourEmailAddress" type="text"
                                        placeholder=" Váše emailová adresa" /> <select name="questionType"><option
                                            value="">- Předmět dotazu -</option>
                                        <option value="technicalProblem">Technický problém</option>
                                        <option value="other">Ostatní</option></select>
                                </div>
                                <div class="popover-content">
                                    <textarea placeholder=" Váš dotaz"></textarea>
                                </div>
                            </div>
                            <button class='btn btn-info submit' type='button'>Odeslat</button>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </section>
            <section class="who-is">
                <h4>Kdo je Marie Skalická?</h4>
                <div class="row-fluid">
                    <div class="span8 text">
                        <p>
                            Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare
                            sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur est at
                            lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                            vestibulum.
                        </p>
                        <p>
                            Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare
                            sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur est at
                            lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                            vestibulum.
                        </p>
                        <p>
                            Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare
                            sem lacinia quam venenatis vestibulum.<br /> Sed posuere consectetur est at
                            lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                            vestibulum.
                        </p>
                    </div>
                    <p class="span4 passport-photo">
                        <img src="images/passportPhoto.png" />
                    </p>
                    <div class="clear"></div>
                </div>
            </section>
        </div>
        <div class="modal-footer">
            <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
        </div>
    </div>
    <div id="cvModal" class="modal hide no-max-height" tabindex="-1" role="dialog"
        aria-labelledby="cvModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="cvModalLabel">Můj životopis</h3>
        </div>
        <div class="modal-body">
            <p>
                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia
                quam venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                Pellentesque ornare sem lacinia quam venenatis vestibulum.
            </p>
        </div>
        <div class="modal-footer">
            <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Zavřít</button>
        </div>
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery/jquery-1.9.1.min.js"></script>
    <script src="jquery/jquery.dateFormat-1.0.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="lib/js/zeptejsepojistovaka-bootstrap.js"></script>
    <script src="lib/js/zeptejsepojistovaka-String.js"></script>
    <script src="lib/js/zeptejsepojistovaka-utils.js"></script>
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
