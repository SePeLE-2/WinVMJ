--
-- PostgreSQL database dump
--

--
-- Data for Name: payment_ewallet; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.payment_ewallet (
    id, amount, objectname, bundlingimpl_id, ticketimpl_id
) VALUES 
('3119ff33-6dd2-4c0a-b113-a90ee32a01ca', 150000, 'TicketingSystem.payment.core.PaymentImpl', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '5119ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3129ff33-6dd2-4c0a-b113-a90ee32a01ca', 200000, 'TicketingSystem.payment.core.PaymentImpl', '4129ff33-6dd2-4c0a-b113-a90ee32a01ca', '5129ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3139ff33-6dd2-4c0a-b113-a90ee32a01ca', 175000, 'TicketingSystem.payment.core.PaymentImpl', '4139ff33-6dd2-4c0a-b113-a90ee32a01ca', '5139ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3149ff33-6dd2-4c0a-b113-a90ee32a01ca', 225000, 'TicketingSystem.payment.core.PaymentImpl', '4149ff33-6dd2-4c0a-b113-a90ee32a01ca', '5149ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('3159ff33-6dd2-4c0a-b113-a90ee32a01ca', 300000, 'TicketingSystem.payment.core.PaymentImpl', '4159ff33-6dd2-4c0a-b113-a90ee32a01ca', '5159ff33-6dd2-4c0a-b113-a90ee32a01ca');

--
-- Name: payment_ewallet payment_ewallet_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.payment_ewallet
    ADD CONSTRAINT payment_ewallet_pkey PRIMARY KEY (id);


--
-- Name: payment_ewallet fk_payment_bundling; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.payment_ewallet
    ADD CONSTRAINT fk_payment_bundling 
    FOREIGN KEY (bundlingimpl_id) 
    REFERENCES public.bundling_comp(id);

--
-- Name: payment_ewallet fk_payment_ticket; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.payment_ewallet
    ADD CONSTRAINT fk_payment_ticket
    FOREIGN KEY (ticketimpl_id)
    REFERENCES public.ticket_comp(id);

--
-- PostgreSQL database dump complete
--

--
-- Data for Name: payment_impl; Type: TABLE DATA; Schema: public; Owner: deployer
--

INSERT INTO public.payment_impl VALUES ('3119ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.payment_impl VALUES ('3129ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.payment_impl VALUES ('3139ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.payment_impl VALUES ('3149ff33-6dd2-4c0a-b113-a90ee32a01ca');
INSERT INTO public.payment_impl VALUES ('3159ff33-6dd2-4c0a-b113-a90ee32a01ca');

--
-- Name: payment_impl payment_impl_pkey; Type: CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.payment_impl
    ADD CONSTRAINT payment_impl_pkey PRIMARY KEY (id);

--
-- Name: payment_impl fk_payment_base; Type: FK CONSTRAINT; Schema: public; Owner: deployer
--

ALTER TABLE ONLY public.payment_impl
    ADD CONSTRAINT fk_payment_base 
    FOREIGN KEY (id) 
    REFERENCES public.payment_ewallet(id);

--
-- PostgreSQL database dump complete
--