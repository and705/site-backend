INSERT INTO users (
                id,
                archive,
                email,
                extra_info,
                name,
                password,
                role,
                surname
            )
values (
                1,
                false,
                'admin@test.com',
                'пользователь администратор',
                'имя админ',
                '$2a$12$VS8if.dv0ozlFxjUuK1YTOv5yOphnYcszAa5zcwR70i9SExp2.HYW',
                'ROLE_ADMIN',
                'фамилия админа'
);

INSERT INTO users (
                id,
                archive,
                email,
                extra_info,
                name,
                password,
                role,
                surname
            )
values (
                2,
                false,
                'client@test.com',
                'пользователь клиент',
                'имя клиента',
                '$2a$12$VS8if.dv0ozlFxjUuK1YTOv5yOphnYcszAa5zcwR70i9SExp2.HYW',
                'ROLE_CLIENT',
                'фамилия клинета'
);

alter sequence user_seq restart with 3
