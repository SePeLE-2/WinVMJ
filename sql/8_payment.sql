-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
select * from public.payment_comp;

-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
-- AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
select * from public.payment_impl;

-- Insert into payment_comp
INSERT INTO public.payment_comp (
    id, amount, objectname, bundling_id, ticket_id
) VALUES (
    '5019ff33-6dd2-4c0a-b113-a90ee32a01ca',
    150000,
    'TicketingSystem.payment.core.PaymentImpl',
    NULL,
    '3119ff33-6dd2-4c0a-b113-a90ee32a01ca'
);

INSERT INTO public.payment_comp (
    id, amount, objectname, bundling_id, ticket_id
) VALUES (
    '5029ff33-6dd2-4c0a-b113-a90ee32a01ca',
    200000,
    'TicketingSystem.payment.core.PaymentImpl',
    '4119ff33-6dd2-4c0a-b113-a90ee32a01ca',
    '3129ff33-6dd2-4c0a-b113-a90ee32a01ca'
);

INSERT INTO public.payment_comp (
    id, amount, objectname, bundling_id, ticket_id
) VALUES (
    '5039ff33-6dd2-4c0a-b113-a90ee32a01ca',
    300000,
    'TicketingSystem.payment.core.PaymentImpl',
    '4119ff33-6dd2-4c0a-b113-a90ee32a01ca',
    '3139ff33-6dd2-4c0a-b113-a90ee32a01ca'
);

INSERT INTO public.payment_comp (
    id, amount, objectname, bundling_id, ticket_id
) VALUES (
    '5049ff33-6dd2-4c0a-b113-a90ee32a01ca',
    250000,
    'TicketingSystem.payment.core.PaymentImpl',
    '4119ff33-6dd2-4c0a-b113-a90ee32a01ca',
    '3149ff33-6dd2-4c0a-b113-a90ee32a01ca'
);

-- INSERT INTO public.payment_comp (
--     id, amount, objectname, bundling_id, ticket_id
-- ) VALUES
-- -- Payment for ticket only
-- ('5019ff33-6dd2-4c0a-b113-a90ee32a01ca', 150000, 'TicketingSystem.payment.core.PaymentImpl', NULL, '3119ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- -- Payment for bundling and ticket
-- ('5029ff33-6dd2-4c0a-b113-a90ee32a01ca', 200000, 'TicketingSystem.payment.core.PaymentImpl', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '3129ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- -- Payment for bundling only (reusing same ticket ref)
-- ('5039ff33-6dd2-4c0a-b113-a90ee32a01ca', 300000, 'TicketingSystem.payment.core.PaymentImpl', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '3139ff33-6dd2-4c0a-b113-a90ee32a01ca'),

-- -- Payment with different bundling
-- ('5049ff33-6dd2-4c0a-b113-a90ee32a01ca', 250000, 'TicketingSystem.payment.core.PaymentImpl', '4119ff33-6dd2-4c0a-b113-a90ee32a01ca', '3149ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Primary Key for payment_comp
ALTER TABLE ONLY public.payment_comp
    ADD CONSTRAINT payment_comp_pkey PRIMARY KEY (id);

-- Foreign Key to ticket_impl
ALTER TABLE ONLY public.payment_comp
    ADD CONSTRAINT fk_payment_ticket
    FOREIGN KEY (ticket_id)
    REFERENCES public.ticket_impl (idticket);

-- Foreign Key to bundling_impl
ALTER TABLE ONLY public.payment_comp
    ADD CONSTRAINT fk_payment_bundling
    FOREIGN KEY (bundling_id)
    REFERENCES public.bundling_impl (id);

-- Insert into payment_impl (subclass)
INSERT INTO public.payment_impl VALUES 
('5019ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('5029ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('5039ff33-6dd2-4c0a-b113-a90ee32a01ca'),
('5049ff33-6dd2-4c0a-b113-a90ee32a01ca');

-- Primary Key for payment_impl
ALTER TABLE ONLY public.payment_impl
    ADD CONSTRAINT payment_impl_pkey PRIMARY KEY (id);

-- FK to payment_comp from subclass
ALTER TABLE ONLY public.payment_impl
    ADD CONSTRAINT fk_payment_impl_comp
    FOREIGN KEY (id)
    REFERENCES public.payment_comp (id);
