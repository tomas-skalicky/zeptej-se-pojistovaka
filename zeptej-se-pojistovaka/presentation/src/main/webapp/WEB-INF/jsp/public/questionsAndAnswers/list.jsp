<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include-preceding-html.jsp"%>

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
                        <input name="question-id" type="hidden" value="20" /> <img src="images/1233576218_panacek-png_67x100.png"
                            class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover right">
                                <div class="arrow"></div>
                                <h3 class="popover-title">
                                    <span class="question-thema">Popover top</span><span class="controls"> <span
                                        class="glyphicon glyphicon-pencil edit" data-toggle="tooltip" title="Upravit"></span> <a
                                        href="#delete-modal" role="button" data-toggle="modal" class="delete"><span
                                            class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                </h3>
                                <div class="popover-content">
                                    <div class="question-text">
                                        Popover top Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem
                                        lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.<br /> <br /> Sed posuere consectetur
                                        est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.
                                    </div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name">Anonym</span> <span class="dot">·</span>
                                    <button class="answer btn btn-link" type="button">Odpovědět</button>
                                    <span class="dot">·</span> <input name='creation-timestamp' type='hidden' value='1374346915000' /><span
                                        class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                    <section class="answer">
                        <input name="answer-id" type="hidden" value="21" /> <img src="images/panacek-uvod.jpg" class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover left">
                                <div class="arrow"></div>
                                <div class="popover-content">
                                    <div class="answer-text">
                                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                        venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.
                                    </div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name"><a href="#contact-modal" data-toggle="modal" class="show-contact">Marie
                                            Skalická</a></span> <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                        value='1374346944000' /><span class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                    <section class="answer">
                        <input name="answer-id" type="hidden" value="22" /> <img src="images/panacek-uvod.jpg" class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover left">
                                <div class="arrow"></div>
                                <div class="popover-content">
                                    <div class="answer-text">Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                        ornare sem lacinia quam venenatis vestibulum.</div>
                                    <span class="controls"><span class="glyphicon glyphicon-pencil edit" data-toggle="tooltip"
                                        title="Upravit"></span><a href="#delete-modal" role="button" data-toggle="modal" class="delete"><span
                                            class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name"><a href="#contact-modal" data-toggle="modal" class="show-contact">Marie
                                            Skalická</a></span> <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                        value='1374346953000' /><span class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                </article>

                <article>
                    <section class="question">
                        <input name="question-id" type="hidden" value="15" /> <img src="images/1233576218_panacek-png_67x100.png"
                            class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover right">
                                <div class="arrow"></div>
                                <h3 class="popover-title">
                                    <span class="question-thema">Popover top</span><span class="controls"><span
                                        class="glyphicon glyphicon-pencil edit" data-toggle="tooltip" title="Upravit"></span><a
                                        href="#delete-modal" role="button" data-toggle="modal" class="delete"><span
                                            class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                </h3>
                                <div class="popover-content">
                                    <div class="question-text">
                                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                        venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.
                                    </div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name">Tom</span> <span class="dot">·</span>
                                    <button class="answer btn btn-link" type="button">Odpovědět</button>
                                    <span class="dot">·</span> <input name='creation-timestamp' type='hidden' value='1374296515000' /><span
                                        class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                </article>

                <article>
                    <section class="question">
                        <input name="question-id" type="hidden" value="10" /> <img src="images/1233576218_panacek-png_67x100.png"
                            class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover right">
                                <div class="arrow"></div>
                                <h3 class="popover-title">
                                    <span class="question-thema">Popover top</span>
                                </h3>
                                <div class="popover-content">
                                    <div class="question-text">Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.</div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name">Anonym</span> <span class="dot">·</span>
                                    <button class="answer btn btn-link" type="button">Odpovědět</button>
                                    <span class="dot">·</span> <input name='creation-timestamp' type='hidden' value='1374271315000' /><span
                                        class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                    <section class="answer">
                        <input name="answer-id" type="hidden" value="11" /> <img src="images/panacek-uvod.jpg" class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover left">
                                <div class="arrow"></div>
                                <div class="popover-content">
                                    <div class="answer-text">Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque
                                        ornare sem lacinia quam venenatis vestibulum.</div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name"><a href="#contact-modal" data-toggle="modal" class="show-contact">Marie
                                            Skalická</a></span> <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                        value='1374271855000' /><span class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                </article>

                <article>
                    <section class="question">
                        <input name="question-id" type="hidden" value="5" /> <img src="images/1233576218_panacek-png_67x100.png"
                            class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover right">
                                <div class="arrow"></div>
                                <h3 class="popover-title">
                                    <span class="question-thema">Popover top</span><span class="controls"><span
                                        class="glyphicon glyphicon-pencil edit" data-toggle="tooltip" title="Upravit"></span><a
                                        href="#delete-modal" role="button" data-toggle="modal" class="delete"><span
                                            class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                </h3>
                                <div class="popover-content">
                                    <div class="question-text">
                                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                        venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.
                                    </div>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name">Julie</span> <span class="dot">·</span>
                                    <button class="answer btn btn-link" type="button">Odpovědět</button>
                                    <span class="dot">·</span> <input name='creation-timestamp' type='hidden' value='1374235855000' /><span
                                        class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                    <section class="answer">
                        <input name="answer-id" type="hidden" value="6" /> <img src="images/panacek-uvod.jpg" class="figure-image" alt="" />
                        <div class="popover-wrapper">
                            <div class="popover left">
                                <div class="arrow"></div>
                                <div class="popover-content">
                                    <div class="answer-text">
                                        Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
                                        venenatis vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam.
                                        Pellentesque ornare sem lacinia quam venenatis vestibulum.
                                    </div>
                                    <span class="controls"><span class="glyphicon glyphicon-pencil edit" data-toggle="tooltip"
                                        title="Upravit"></span><a href="#delete-modal" data-toggle="modal" class="delete"><span
                                            class="glyphicon glyphicon-remove" data-toggle="tooltip" title="Smazat"></span></a></span>
                                </div>
                                <div class="popover-footer grey">
                                    <span class="author-name"><a href="#contact-modal" data-toggle="modal" class="show-contact">Marie
                                            Skalická</a></span> <span class="dot">·</span> <input name='creation-timestamp' type='hidden'
                                        value='1332413882588' /><span class="time continuously-updated"></span>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </section>
                </article>
            </div>
        </div>
    </div>

    <%@ include file="pagination.jsp"%>
</section>
