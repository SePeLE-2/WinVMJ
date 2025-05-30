
INSERT INTO public.comment_comp (
    idcontent, comment, commentauthor, objectname, 
    articleimpl_idarticle, customerimpl_id, eventorganizerimpl_id
) VALUES
-- Komentar dari customer Andi B. pada artikel Hendra
('3019ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Komentar dari Andi untuk artikel Hendra', 'Andi B.', 'comment_impl',
 '2119ff33-6dd2-4c0a-b113-a90ee32a01ca', '1119ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),

-- Komentar dari customer Budi C. pada artikel Indah
('3029ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Komentar dari Budi untuk artikel Indah', 'Budi C.', 'comment_impl',
 '2129ff33-6dd2-4c0a-b113-a90ee32a01ca', '1129ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL),

-- Komentar dari Event Organizer Hendra untuk artikel Joko
('3039ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Komentar dari EO Hendra untuk artikel Joko', 'Hendra I.', 'comment_impl',
 '2139ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL, '2119ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- Komentar dari Event Organizer Indah untuk artikel Kiki
('3049ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Komentar dari EO Indah untuk artikel Kiki', 'Indah J.', 'comment_impl',
 '2149ff33-6dd2-4c0a-b113-a90ee32a01ca', NULL, '2129ff33-6dd2-4c0a-b113-a90ee32a01ca');


-- Primary Key
ALTER TABLE ONLY public.comment_comp
    ADD CONSTRAINT comment_comp_pkey PRIMARY KEY (idcontent);

-- FK ke article_impl
ALTER TABLE ONLY public.comment_comp
    ADD CONSTRAINT fk_comment_article
    FOREIGN KEY (articleimpl_idarticle)
    REFERENCES public.article_impl (idarticle);

-- FK ke customer_comp
ALTER TABLE ONLY public.comment_comp
    ADD CONSTRAINT fk_comment_customer
    FOREIGN KEY (customerimpl_id)
    REFERENCES public.customer_comp (id);

-- FK ke eventorganizer_comp
ALTER TABLE ONLY public.comment_comp
    ADD CONSTRAINT fk_comment_eventorganizer
    FOREIGN KEY (eventorganizerimpl_id)
    REFERENCES public.eventorganizer_comp (id);



INSERT INTO public.comment_impl VALUES 
('3019ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3029ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3039ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3049ff33-6dd2-4c0a-b113-a90ee32a01ca');

--
-- Name: article_impl article_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.comment_impl
    ADD CONSTRAINT comment_impl_pkey PRIMARY KEY (idcontent);


--
-- Name: article_impl fkcgt3b11pyw11nfm3b5gwhesjl; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.comment_impl
    ADD CONSTRAINT fkcgt3b11pyw11nfm3b5gwhesjl FOREIGN KEY (idcontent) REFERENCES public.comment_comp(idcontent);


--
-- PostgreSQL database dump complete
--

