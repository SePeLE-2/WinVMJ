--
-- PostgreSQL database dump
--
--
-- Data for Name: article_comp; Type: TABLE DATA; Schema: public; Owner: deployer
--
INSERT INTO public.article_comp (
    idarticle, articleauthor, articlecontent, articledatepublished, 
    articletitle, objectname, eventorganizerimpl_id
) VALUES 
('2119ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Hendra I.', 'Konten artikel oleh Hendra', '2024-01-01', 'Judul Artikel Hendra', 'TicketingSystem.article.core.ArticleImpl', '2119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2129ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Indah J.', 'Konten artikel oleh Indah', '2024-01-02', 'Judul Artikel Indah', 'TicketingSystem.article.core.ArticleImpl', '2129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2139ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Joko K.', 'Konten artikel oleh Joko', '2024-01-03', 'Judul Artikel Joko', 'TicketingSystem.article.core.ArticleImpl', '2139ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2149ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Kiki L.', 'Konten artikel oleh Kiki', '2024-01-04', 'Judul Artikel Kiki', 'TicketingSystem.article.core.ArticleImpl', '2149ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('2159ff33-6dd2-4c0a-b113-a90ee32a01ca', 'Lina M.', 'Konten artikel oleh Lina', '2024-01-05', 'Judul Artikel Lina', 'TicketingSystem.article.core.ArticleImpl', '2159ff33-6dd2-4c0a-b113-a90ee32a01ca');


--
-- Name: article_comp article_comp_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.article_comp
    ADD CONSTRAINT article_comp_pkey PRIMARY KEY (idarticle);


--
-- Name: article_comp uksgy2awg3v8vv8pt8t8srb7a2s; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.article_comp
    ADD CONSTRAINT uksgy2awg3v8vv8pt8t8srb7a2s UNIQUE (email);

ALTER TABLE ONLY public.article_comp
    ADD CONSTRAINT fk_eventorganizer
    FOREIGN KEY (eventorganizerimpl_id)
    REFERENCES public.eventorganizer_comp(id);


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database dump
--
-- Data for Name: article_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.article_impl VALUES ('2119ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.article_impl VALUES ('2129ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.article_impl VALUES ('2139ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.article_impl VALUES ('2149ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.article_impl VALUES ('2159ff33-6dd2-4c0a-b113-a90ee32a01ca');


--
-- Name: article_impl article_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.article_impl
    ADD CONSTRAINT article_impl_pkey PRIMARY KEY (idarticle);


--
-- Name: article_impl fkcgt3b11pyw11nfm3b5gwhesjl; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.article_impl
    ADD CONSTRAINT fkcgt3b11pyw11nfm3b5gwhesjl FOREIGN KEY (idarticle) REFERENCES public.article_comp(idarticle);


--
-- PostgreSQL database dump complete
--

