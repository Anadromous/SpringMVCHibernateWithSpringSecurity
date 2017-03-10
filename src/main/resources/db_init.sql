

INSERT INTO websystique.USER_PROFILE(type)
VALUES ('USER');
  
INSERT INTO websystique.USER_PROFILE(type)
VALUES ('ADMIN');
  
INSERT INTO websystique.USER_PROFILE(type)
VALUES ('DBA');

INSERT INTO websystique.APP_USER(enabled, password, sso_id)
VALUES (1,'$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'pchapman');

INSERT INTO websystique.customer (email, phone, first_name, last_name, SSO_ID, user_id)
VALUES('pchapman@easystreet.net','503-449-0882','Peter','Chapman', 'pchapman', (select user_id from websystique.app_user where sso_id = 'pchapman'));

UPDATE websystique.app_user set customer_customer_id = (select customer_id from websystique.customer where customer.SSO_ID = 'pchapman')
where app_user.SSO_ID = 'pchapman';

INSERT INTO websystique.APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.USER_ID, profile.id FROM websystique.app_user user, websystique.user_profile profile
  where user.sso_id='pchapman' and profile.type='ADMIN';

select * from websystique.app_user;
select * from websystique.customer;
