<%@ page pageEncoding="UTF-8"%>
<%@ include file="../include-preceding-html.jsp"%>

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
                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                                vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem
                                lacinia quam venenatis vestibulum.
                            </p>
                            <p>
                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                                vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem
                                lacinia quam venenatis vestibulum.
                            </p>
                            <p>
                                Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis
                                vestibulum.<br /> Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem
                                lacinia quam venenatis vestibulum.
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
