package com.ccl.yuedu.message;

public enum CustomMessage {
    WECHAT_BIND_SUCCESS(0),
    WECHAT_BIND_FAILED(2),
    COOKIE_EXPIRED(3),
    MOBILE_LOGIN_SUCCESS(4),
    MOBILE_LOGIN_FAILED(5),
    BIND_MOBILE_SUCCESS(6),
    BIND_MOBILE_FAILED(7),
    SMS_SENT(10),
    UPDATE_CAR_INFO_SUCCESS(17),
    UPDATE_CAR_INFO_FAILED(18),
    GET_PRICE_SUCCESS(20),
    GET_PRICE_FAILED(21),
    SUPPLEMENT_INFO_NEEDED(22),
    GET_PRICE_TIMEOUT(23),
    APP_HAS_UPDATE(25),
    APP_FORCE_UPDATE(26),
    GET_PERSONAL_INFO(27),
    GET_USER_POINT(29),
    GET_OPERATING_ADV_INFO(30),
    UPDATE_PERSONAL_INFO_SUCCESS(35),
    UPDATE_PERSONAL_INFO_FAILED(36),
    UPDATE_PERSONAL_INFO_FIELD_SUCCESS(37),
    UPDATE_PERSONAL_INFO_FIELD_FAILED(38),
    ADD_CAR_FAILED(39),
    NO_RESPONSE(40),
    GET_POINT_DETAILS_SUCCESS(41),
    GET_POINT_DETAILS_FAILED(42),
    GET_RECOMMEND_DETAILS_SUCCESS(43),
    GET_RECOMMEND_DETAILS_FAILED(44),
    GET_USER_ID(46),
    GET_NEW_NOTICE_MESSAGE_NUMBER(50),
    GET_NAME_AUTH_INFO_SUCCESS(55),
    UPDATE_ID_CARD_PHOTO(56),
    NAME_AUTH_INFO_SUBMIT_SUCCESS(57),
    NAME_AUTH_INFO_SUBMIT_FAILED(58),
    TAKE_ID_CARD_PHOTO(60),
    SELECT_ID_CARD_PHOTO(61),
    GET_WALLET_INFO_ERROR(65),
    GET_WALLET_INFO(66),
    GET_WALLET_INCOME_DETAILS(67),
    GET_WALLET_OUTCOME_DETAILS(68),
    WITHDRAW_SUBMIT_SUCCESS(69),
    WITHDRAW_SUBMIT_FAILED(70),
    GET_YONGAN_WECHAT_PAY_PARAM_SUCCESS(73),
    GET_YONGAN_WECHAT_PAY_PARAM_FAILED(74),
    INSURANCE_START_DATE_MATCH(75),
    INSURANCE_START_DATE_NOT_MATCH(76),
    PRICE_HISTORY_EXPIRED(77),
    GET_INSURANCE_START_DATE(78),
    GET_INSURANCE_START_DATE_INVALID(79),
    SELECT_PORTRAIT_PHOTO(81),
    UPLOAD_PORTRAIT_SUCCESS(82),
    GET_PORTRAIT_SUCCESS(83),
    TAKE_PORTRAIT_PHOTO(84),
    GET_TIMESTAMP(86),
    JOIN_TEAM_REQUEST_FAILED(87),
    GET_PERSONAL_TEAM_INFO(90),
    GET_TEAM_LIST(91),
    CREATE_TEAM_AUTHORIZED(92),
    CREATE_TEAM_UNAUTHORIZED(93),
    GET_TEAM_DETAILS(94),
    JOIN_TEAM_REQUEST_SENT(95),
    GET_CREATE_TEAM_RULE(96),
    SELECT_TEAM_LOGO_PHOTO(98),
    TAKE_TEAM_LOGO_PHOTO(99),
    CREATE_TEAM_SUCCESS(100),
    CREATE_TEAM_FAILED(101),
    GET_APPLICANT_LIST(102),
    GET_TEAM_MEMBER_LIST(103),
    PROCEED_JOIN_TEAM_APPLICANT_SUCCESS(104),
    UPDATE_TEAM_INFO_SUCCESS(105),
    SELECT_ID_CARD_PHOTO_PATH(106),
    SELECT_PORTRAIT_PHOTO_PATH(108),
    TAKE_PORTRAIT_PHOTO_PATH(109),
    SELECT_TEAM_LOGO_PHOTO_PATH(110),
    TAKE_TEAM_LOGO_PHOTO_PATH(111),
    LOGOUT(112),
    GET_QINIU_KEY_TOKEN(120),
    QINIU_UPLOAD_SUCCESS(121),
    QINIU_UPLOAD_FAILED(122),
    GET_WECHAT_AUTH_CODE(123),
    WECHAT_AUTH_CANCELLED(124),
    WECHAT_AUTH_DENIED(125),
    GET_PERSONAL_PREMIUM(126),
    GET_PREMIUM_MONTH_RANK(127),
    GET_INSURANCE_SERVICE(130),
    GET_INSURANCE_SITE(131),
    GET_YONGAN_ALIPAY_PARAM_SUCCESS(132),
    GET_YONGAN_ALIPAY_PARAM_FAILED(133),
    CHECK_ALIPAY_EXIST(134),
    ALIPAY_PAY_RESULT(135),
    GO_TO_PRICELIST(138),
    SMS_SENT_FAILED(139),
    GENERATE_INVITE_URL(140),
    GENERATE_INVITE_URL_ERROR(141),
    GENERATE_PRICE_SHARE_URL(142),
    SEARCH_TEAM_MEMBER_RESULT(143),
    GET_SUB_TEAM_LIST(144),
    GET_BANNER_LIST(145),
    GET_BANNER_FAILED(146),
    GET_CUSTOMER_LIST_NOT_ORDER(170),
    GET_CUSTOMER_LIST_FAILED(172),
    SEARCH_CUSTOMER_RESULT(173),
    GET_LIFE_INS_SHARE_IDENTIFY(176),
    GET_TEAM_INVITE_CANDIDATE(177),
    SEND_TEAM_INVITE_SUCCESS(178),
    SHOW_SERVER_MESSAGE(180),
    SEARCH_RECOMMEND_RECORD(182),
    GET_MY_INVITE_LIST_SUCCESS(183),
    GET_MY_INVITE_LIST_ERROR(184),
    JOIN_TEAM_AUTO_PASSED(185),
    SEARCH_TEAM_MEMBER_RESULT_FAILED(186),
    GET_INSURANCE_START_DATE_FAILED(188),
    GET_QINIU_KEY_TOKEN_FAILED(189),
    QUERY_CAR_INFO_SUCCESS(191),
    QUERY_CAR_INFO_FAILED(192),
    QUIT_TEAM_SENT_SUCCESS(193),
    QUIT_TEAM_SENT_FAILED(194),
    GET_QUIT_TEAM_APPLICANT_LIST(196),
    PROCESS_QUIT_TEAM_SUCCESS(197),
    GENERATE_RECOMMEND_TEAM_LEADER_URL(198),
    GET_MAIN_PAGE_ADVERTISEMENT(199),
    GET_NOTICECENTER_CARINSURANCE_POLICY_LIST(200),
    GET_NOTICECENTER_ACTIVITY_LIST(201),
    GET_NOTICECENTER_NOTICE_LIST(202),
    GET_QUERY_PRICE_LIST_CONFIG(206),
    VISITOR_LOGIN_SUCCESS(207),
    VISITOR_LOGIN_FAILED(208),
    EXCEED_VISITOR_QUERY_PRICE_LIMIT(209),
    GET_NOTICE_DETAIL(211),
    GET_DUIBA_URL_SUCCESS(214),
    GET_DUIBA_URL_ERROR(215),
    GET_LOGIN_STATUS(216),
    GET_TEAM_NOTICE_DETAIL_SUCCESS(217),
    GET_TEAM_NOTICE_DETAIL_ERROR(218),
    GET_QA_LIST_SUCCESS(219),
    GET_QA_LIST_ERROR(220),
    GET_MAIN_SQUARE_GET_CUSTOMER_ARTICLE_LIST(224),
    GET_MAIN_SQUARE_GET_CUSTOMER_BANNER(225),
    GET_MAIN_SQUARE_ADD_NEW_MEMBER_LIST(226),
    GET_MAIN_SQUARE_ADD_NEW_MEMBER_BANNER(227),
    BIND_EMAIL_SUCCESS(230),
    BIND_EMAIL_ERROR(231),
    GET_PORTRAIT_URL_SUCCESS(232),
    GET_PORTRAIT_URL_ERROR(233),
    GET_BUSINESS_CARD_SHARE_INFO_SUCCESS(234),
    GET_BUSINESS_CARD_SHARE_INFO_ERROR(235),
    GENERATE_EXPERIENCE_STATION_URL(238),
    GET_CAR_INFO_FOR_RENEW(240),
    NETWORK_AVAILABLE(241),
    GET_CERTS_AND_CHECK_CAR_IMAGES_SUCCESS(243),
    GET_CERTS_AND_CHECK_CAR_IMAGES_FAILED(244),
    SUBMIT_VEHICLE_CAR_PHOTO_SUCCESS(245),
    SUBMIT_VEHICLE_CAR_PHOTO_ERROR(246),
    GET_IMAGE_RECOGNITION_INFO_SUCCESS(247),
    GET_IMAGE_RECOGNITION_INFO_ERROR(248),
    GET_CUStOMER_EXISTENCE_SUCCESS(249),
    GET_CUSTOMER_EXISTENCE_ERROR(250),
    CUSTOMER_SEARCH_SUCCESS(251),
    CUSTOMER_SEARCH_ERROR(252),
    GET_CUSTOMER_DETAIL_SUCCESS(253),
    GET_CUSTOMER_DETAIL_ERROR(254),
    GET_VEHICLE_INSURANCE_DETAIL_SUCCESS(255),
    GET_VEHICLE_INSURANCE_DETAIL_ERROR(256),
    GET_HISTORY_POLICY_SUCCESS(257),
    GET_HISTORY_POLICY_ERROR(258),
    CUSTOMER_ADD_CAR_INFO_SUCCESS(259),
    CUSTOMER_ADD_CAR_INFO_ERROR(260),
    CUSTOMER_UPDATE_CUSTOMER_INFO_SUCCESS(261),
    CUSTOMER_UPDATE_CUSTOMER_INFO_ERROR(262),
    CUSTOMER_UPDATE_CAR_INFO_SUCCESS(263),
    CUSTOMER_UPDATE_CAR_INFO_ERROR(264),
    CUSTOMER_DEL_CUSTOMER_SUCCESS(265),
    CUSTOMER_DEL_CUSTOMER_ERROR(266),
    CUSTOMER_DEL_CAR_SUCCESS(267),
    CUSTOMER_DEL_CAR_ERROR(268),
    CUSTOMER_ADD_CUSTOMER_BASE_INFO_SUCCESS(269),
    CUSTOMER_ADD_CUSTOMER_BASE_INFO_ERROR(270),
    CUSTOMER_ADD_CUSTOMER_INFO_WITH_CAR_SUCCESS(271),
    CUSTOMER_ADD_CUSTOMER_INFO_WITH_CAR_ERROR(272),
    CUSTOMER_SPECIAL_HANDLE_ADD_CAR_SUCCESS(273),
    SUBMIT_FEEDBACK_SUCCESS(274),
    GET_TEAM_MEMBER_LIST_ERROR(275),
	GET_TEAM_REPORT_SUCCESS(276),
    GET_TEAM_REPORT_ERROR(277),
    DAILY_SIGN_SUCCESS(278),
    SEARCH_CAR_TYPE_SUCCESS(279),
    ADD_CAR_SUCCESS(280),
    GET_USER_MESSAGE_DETAIL(281),
    UNDERWRITE_RESULT_NORMAL(283),
    UNDERWRITE_RESULT_DUPLICATE_ORDER(284),
    UNDERWRITE_RESULT_EXCEPTION(285),
    DELETE_ORDER_SUCCESS(286),
    MAIN_PAGE_SHARE(287),
    CUSTOMER_ADD_CAR_HAS_DUPLICATE_CAR(288),
    CUSTOMER_ADD_HAS_DUPLICATE_CUSTOMER(289),
    GET_SHOW_BONUS_CONFIG(290),
    SET_SHOW_BONUS_CONFIG_SUCCESS(291),
    SET_SHOW_BONUS_CONFIG_FAILED(292),
    GET_MAINPAGE_DATA_SUCCESS(293),
    GET_MAINPAGE_DATA_FAIL(294),
    GET_MAINPAGE_MARQUESS_LIST_SUCCESS(295),
    GET_TEAM_MEMBER_ORDER_LIST_SUCCESS(296),
    GET_TEAM_MEMBER_ORDER_LIST_ERROR(297),
    GET_TEAM_QUERY_RESULTS_SUCCESS(298),
    GET_TEAM_QUERY_RESULTS_ERROR(299),
    GIFT_INSURANCE_SUCCESS(300),
    GIFT_INSURANCE_FAIL(301),
    UNDERWRITE_RESULT_DUPLICATE_ORDER_SAME_COMPANY(302),
    GIFT_INSURANCE_ACCOUNT_REGISTERED(303),
    UPDATE_TEAM_INFO_ERROR(304),
    GET_TEAM_DETAILS_ERROR(305),
    GENERATE_COMMON_REFEREE_URL_SUCCESS(306),
    GET_TQ_INFO(307),
    GIFT_INSURANCE_CANT_REPEAT_TO_RECEIVE(308),
    SHARE_SUCCESS(309),
    SET_NOTICE_CENTER_CAR_INSURANCE_POLICY_HAS_READ_SUCCESS(310),
    SET_NOTICE_CENTER_ACTIVITY_HAS_READ_SUCCESS(311),
    SET_NOTICE_CENTER_NOTICE_HAS_READ_SUCCESS(312),
    SET_NOTICE_CENTER_CAR_INSURANCE_POLICY_ALL_READ_SUCCESS(313),
    SET_NOTICE_CENTER_ACTIVITY_ALL_READ_SUCCESS(314),
    SET_NOTICE_CENTER_NOTICE_ALL_READ_SUCCESS(315),
    NOTICE_CENTER_REQUEST_FAIL(316),
    GET_MINE_INFO_SUCCESS(317),
    GET_MINE_INFO_ERROR(318),
    APP_HAS_NOT_UPDATE(319),
    CUSTOMER_GET_ALL_CUSTOMER_SUCCESS(320),
    CUSTOMER_GET_ALL_CUSTOMER_ERROR(321),
    CUSTOMER_IMPORT_CUSTOMER_SUCCESS(322),
    CUSTOMER_IMPORT_CUSTOMER_ERROR(323),
    CUSTOMER_IMPORT_CUSTOMER_PART_SUCCESS(324),
    GET_RECORD_STATUS_SUCCESS(325),
    AGENT_RECORD_COMMIT_INFO_SUCCESS(326),
    AGENT_RECORD_COMMIT_INFO_FAIL(327),
    PUT_ON_RECORD_SUCCESS(328),
    CUSTOMER_UPDATE_CAR_ID_NO_SUCCESS(329),
    CUSTOMER_UPDATE_CAR_ID_NO_ERROR(330),
    GET_ACCIDENT_INSURANCE_LIST_SUCCESS(331),
    GET_ACCIDENT_INSURANCE_FILTER_DATA_SUCCESS(332),
    WITHDRAWAL_FINISH(333),
    WITHDRAW_BY_BANKCARD_FIRST_COMMIT_SUCCESS(334),
    WITHDRAW_BY_BANKCARD_FIRST_COMMIT_FAIL(335),
    WITHDRAW_BY_BANKCARD_SECOND_COMMIT_SUCCESS(336),
    WITHDRAW_BY_BANKCARD_SECOND_COMMIT_FAIL(337),
    GET_WALLET_INCOME_DETAILS_FAIL(338),
    GET_WALLET_OUTCOME_DETAILS_FAIL(339),
    GET_MY_ORDER_ALL_LIST_SUCCESS(340),
    GET_MY_ORDER_ALL_LIST_FAIL(341),
    GET_MY_ORDER_PENDING_PAYMENT_LIST_SUCCESS(342),
    GET_MY_ORDER_PENDING_PAYMENT_LIST_FAIL(343),
    GET_MY_ORDER_COMPLETED_LIST_SUCCESS(344),
    GET_MY_ORDER_COMPLETED_LIST_FAIL(345),
    CAR_INSURANCE_GET_ADDRESS_SUCCESS(346),
    CAR_INSURANCE_GET_ADDRESS_FAIL(347),
	GET_TEAM_MEMBER_DETAIL_SUCCESS(348),
    GET_TEAM_MEMBER_DETAIL_ERROR(349),
	GET_WALLET_FROZEN_LIST_SUCCESS(350),
    GET_WALLET_FROZEN_LIST_FAIL(351),
    GET_WALLET_FROZEN_DONATE_ID_SUCCESS(352),
    GET_WALLET_FROZEN_DONATE_ID_FAIL(353),
    QUERY_CAR_INSURANCE_ORDER_INFO_SUCCESS(354),
    QUERY_CAR_INSURANCE_ORDER_INFO_FAIL(355),
    WALLET_FROZEN_REVOCATION_SUCCESS(356),
    WALLET_FROZEN_REVOCATION_FAIL(357),
    GET_JOINED_INVITATION_SUCCESS(358),
    GET_JOINED_INVITATION_ERROR(359),
    GET_NOT_JOINED_INVITATION_SUCCESS(360),
    GET_NOT_JOINED_INVITATION_ERROR(361),
    GET_GROUP_MEMBER_INFO_SUCCESS(362),
    GET_GROUP_MEMBER_INFO_ERROR(363),
    GET_PREMIUM_RANK_SUCCESS(364),
    SEND_TEAM_INVITE_ERROR(365),
    GET_PREMIUM_RANK_ERROR(366),
    REQUEST_COMPANY_LIST_SUCCESS(367),
    REQUEST_COMPANY_LIST_FAIL(368),
    COMMIT_INSURED_ADDRESS_SUCCESS(369),
    COMMIT_INSURED_ADDRESS_FAIL(370),
    UNDERWRITE_RESULT_FAIL(371),
    GENERATE_COMMON_REFEREE_URL_FAIL(372),
    APP_UPDATE_SUCCESS(373),
    GET_CREATE_GROUP_CLAIM_SUCCESS(374),
    GET_CREATE_GROUP_CLAIM_ERROR(375),
    TEAM_SEARCH_GROUP_SUCCESS(376),
    TEAM_SEARCH_GROUP_ERROR(377),
    JOIN_TEAM_SUCCESS(378),
    JOIN_TEAM_ERROR(379),
    QUICK_JOIN_TEAM_SUCCESS(382),
    QUICK_JOIN_TEAM_ERROR(383),
    GET_CAR_PRICE_HISTORY_SUCCESS(384),
    GET_CAR_PRICE_HISTORY_ERROR(385),
    SEARCH_CAR_TYPE_FAIL(386),
    GET_OIL_CARD_CONFIG_SUCCESS(387),
    GET_OIL_CARD_CONFIG_ERROR(388),
    ADD_CUSTOM_MODEL_SUCCESS(389),
    ADD_CUSTOM_MODEL_FAIL(390),
    POST_RECORD_BLACK_USER_SUCCESS(391),
    POST_RECORD_BLACK_USER_ERROR(392),
    WITHDRAW_INSERT_BANK_CARD_SUCCESS(393),
    WITHDRAW_INSERT_BANK_CARD_ERROR(394),
    GET_BANK_LIST_SUCCESS(395),
    GET_BANK_LIST_ERROR(396),
    GET_WITHDRAW_BASE_INFO_SUCCESS(397),
    GET_WITHDRAW_BASE_INFO_ERROR(398),
    GET_ALL_BANK_LIST_SUCCESS(399),
    GET_ALL_BANK_LIST_ERROR(400),
	GET_NAME_AUTH_INFO_FAIL(401),
    GET_LATEST_QUERY_CAR_INFO_SUCCESS(402),
    GET_LATEST_QUERY_CAR_INFO_FAIL(403),
    GET_ALL_LATEST_QUERY_CAR_INFO_SUCCESS(404),
    GET_ALL_LATEST_QUERY_CAR_INFO_FAIL(405),
    QUERY_CAR_INFO_SUCCESS_NEW(406),
    QUERY_CAR_INFO_FAIL_NEW(407),
    GET_PAGE_PARAMS_CONFIG_SUCCESS(408),
    GET_PAGE_PARAMS_CONFIG_ERROR(409),
    ADD_OR_UPDATE_CAR_INFO_SUCCESS(410),
    ADD_OR_UPDATE_CAR_INFO_ERROR(411),
    GET_ORDER_STATUS_SUCCESS(412),
    GET_ORDER_STATUS_ERROR(413),
    GET_PRICE_TO_ARTIFICIAL_PRICE(414),
    SELECT_INS_AGENCY_JUMP_INSURANCE_INFO(415);
    private int m_nValue = 0;

    CustomMessage(int nValue) {
        m_nValue = nValue;
    }

    public int getValue() {
        return m_nValue;
    }

    public static CustomMessage fromValue(int nValue) {
        switch (nValue) {
            case 0:
                return WECHAT_BIND_SUCCESS;
            case 2:
                return WECHAT_BIND_FAILED;
            case 3:
                return COOKIE_EXPIRED;
            case 4:
                return MOBILE_LOGIN_SUCCESS;
            case 5:
                return MOBILE_LOGIN_FAILED;
            case 6:
                return BIND_MOBILE_SUCCESS;
            case 7:
                return BIND_MOBILE_FAILED;
            case 10:
                return SMS_SENT;
            case 17:
                return UPDATE_CAR_INFO_SUCCESS;
            case 18:
                return UPDATE_CAR_INFO_FAILED;
            case 20:
                return GET_PRICE_SUCCESS;
            case 21:
                return GET_PRICE_FAILED;
            case 22:
                return SUPPLEMENT_INFO_NEEDED;
            case 23:
                return GET_PRICE_TIMEOUT;
            case 25:
                return APP_HAS_UPDATE;
            case 26:
                return APP_FORCE_UPDATE;
            case 27:
                return GET_PERSONAL_INFO;
            case 29:
                return GET_USER_POINT;
            case 30:
                return GET_OPERATING_ADV_INFO;
            case 35:
                return UPDATE_PERSONAL_INFO_SUCCESS;
            case 36:
                return UPDATE_PERSONAL_INFO_FAILED;
            case 37:
                return UPDATE_PERSONAL_INFO_FIELD_SUCCESS;
            case 38:
                return UPDATE_PERSONAL_INFO_FIELD_FAILED;
            case 39:
                return ADD_CAR_FAILED;
            case 40:
                return NO_RESPONSE;
            case 41:
                return GET_POINT_DETAILS_SUCCESS;
            case 42:
                return GET_POINT_DETAILS_FAILED;
            case 43:
                return GET_RECOMMEND_DETAILS_SUCCESS;
            case 44:
                return GET_RECOMMEND_DETAILS_FAILED;
            case 46:
                return GET_USER_ID;
            case 50:
                return GET_NEW_NOTICE_MESSAGE_NUMBER;
            case 55:
                return GET_NAME_AUTH_INFO_SUCCESS;
            case 56:
                return UPDATE_ID_CARD_PHOTO;
            case 57:
                return NAME_AUTH_INFO_SUBMIT_SUCCESS;
            case 58:
                return NAME_AUTH_INFO_SUBMIT_FAILED;
            case 60:
                return TAKE_ID_CARD_PHOTO;
            case 61:
                return SELECT_ID_CARD_PHOTO;
            case 65:
                return GET_WALLET_INFO_ERROR;
            case 66:
                return GET_WALLET_INFO;
            case 67:
                return GET_WALLET_INCOME_DETAILS;
            case 68:
                return GET_WALLET_OUTCOME_DETAILS;
            case 69:
                return WITHDRAW_SUBMIT_SUCCESS;
            case 70:
                return WITHDRAW_SUBMIT_FAILED;
            case 73:
                return GET_YONGAN_WECHAT_PAY_PARAM_SUCCESS;
            case 74:
                return GET_YONGAN_WECHAT_PAY_PARAM_FAILED;
            case 75:
                return INSURANCE_START_DATE_MATCH;
            case 76:
                return INSURANCE_START_DATE_NOT_MATCH;
            case 77:
                return PRICE_HISTORY_EXPIRED;
            case 78:
                return GET_INSURANCE_START_DATE;
            case 79:
                return GET_INSURANCE_START_DATE_INVALID;
            case 81:
                return SELECT_PORTRAIT_PHOTO;
            case 82:
                return UPLOAD_PORTRAIT_SUCCESS;
            case 83:
                return GET_PORTRAIT_SUCCESS;
            case 84:
                return TAKE_PORTRAIT_PHOTO;
            case 86:
                return GET_TIMESTAMP;
            case 87:
                return JOIN_TEAM_REQUEST_FAILED;
            case 90:
                return GET_PERSONAL_TEAM_INFO;
            case 91:
                return GET_TEAM_LIST;
            case 92:
                return CREATE_TEAM_AUTHORIZED;
            case 93:
                return CREATE_TEAM_UNAUTHORIZED;
            case 94:
                return GET_TEAM_DETAILS;
            case 95:
                return JOIN_TEAM_REQUEST_SENT;
            case 96:
                return GET_CREATE_TEAM_RULE;
            case 98:
                return SELECT_TEAM_LOGO_PHOTO;
            case 99:
                return TAKE_TEAM_LOGO_PHOTO;
            case 100:
                return CREATE_TEAM_SUCCESS;
            case 101:
                return CREATE_TEAM_FAILED;
            case 102:
                return GET_APPLICANT_LIST;
            case 103:
                return GET_TEAM_MEMBER_LIST;
            case 104:
                return PROCEED_JOIN_TEAM_APPLICANT_SUCCESS;
            case 105:
                return UPDATE_TEAM_INFO_SUCCESS;
            case 106:
                return SELECT_ID_CARD_PHOTO_PATH;
            case 108:
                return SELECT_PORTRAIT_PHOTO_PATH;
            case 109:
                return TAKE_PORTRAIT_PHOTO_PATH;
            case 110:
                return SELECT_TEAM_LOGO_PHOTO_PATH;
            case 111:
                return TAKE_TEAM_LOGO_PHOTO_PATH;
            case 112:
                return LOGOUT;
            case 120:
                return GET_QINIU_KEY_TOKEN;
            case 121:
                return QINIU_UPLOAD_SUCCESS;
            case 122:
                return QINIU_UPLOAD_FAILED;
            case 123:
                return GET_WECHAT_AUTH_CODE;
            case 124:
                return WECHAT_AUTH_CANCELLED;
            case 125:
                return WECHAT_AUTH_DENIED;
            case 126:
                return GET_PERSONAL_PREMIUM;
            case 127:
                return GET_PREMIUM_MONTH_RANK;
            case 130:
                return GET_INSURANCE_SERVICE;
            case 131:
                return GET_INSURANCE_SITE;
            case 132:
                return GET_YONGAN_ALIPAY_PARAM_SUCCESS;
            case 133:
                return GET_YONGAN_ALIPAY_PARAM_FAILED;
            case 134:
                return CHECK_ALIPAY_EXIST;
            case 135:
                return ALIPAY_PAY_RESULT;
            case 138:
                return GO_TO_PRICELIST;
            case 139:
                return SMS_SENT_FAILED;
            case 140:
                return GENERATE_INVITE_URL;
            case 141:
                return GENERATE_INVITE_URL_ERROR;
            case 142:
                return GENERATE_PRICE_SHARE_URL;
            case 143:
                return SEARCH_TEAM_MEMBER_RESULT;
            case 144:
                return GET_SUB_TEAM_LIST;
            case 145:
                return GET_BANNER_LIST;
            case 146:
                return GET_BANNER_FAILED;
            case 170:
                return GET_CUSTOMER_LIST_NOT_ORDER;
            case 172:
                return GET_CUSTOMER_LIST_FAILED;
            case 173:
                return SEARCH_CUSTOMER_RESULT;
            case 176:
                return GET_LIFE_INS_SHARE_IDENTIFY;
            case 177:
                return GET_TEAM_INVITE_CANDIDATE;
            case 178:
                return SEND_TEAM_INVITE_SUCCESS;
            case 180:
                return SHOW_SERVER_MESSAGE;
            case 182:
                return SEARCH_RECOMMEND_RECORD;
            case 183:
                return GET_MY_INVITE_LIST_SUCCESS;
            case 184:
                return GET_MY_INVITE_LIST_ERROR;
            case 185:
                return JOIN_TEAM_AUTO_PASSED;
            case 186:
                return SEARCH_TEAM_MEMBER_RESULT_FAILED;
            case 188:
                return GET_INSURANCE_START_DATE_FAILED;
            case 189:
                return GET_QINIU_KEY_TOKEN_FAILED;
            case 191:
                return QUERY_CAR_INFO_SUCCESS;
            case 192:
                return QUERY_CAR_INFO_FAILED;
            case 193:
                return QUIT_TEAM_SENT_SUCCESS;
            case 194:
                return QUIT_TEAM_SENT_FAILED;
            case 196:
                return GET_QUIT_TEAM_APPLICANT_LIST;
            case 197:
                return PROCESS_QUIT_TEAM_SUCCESS;
            case 198:
                return GENERATE_RECOMMEND_TEAM_LEADER_URL;
            case 199:
                return GET_MAIN_PAGE_ADVERTISEMENT;
            case 200:
                return GET_NOTICECENTER_CARINSURANCE_POLICY_LIST;
            case 201:
                return GET_NOTICECENTER_ACTIVITY_LIST;
            case 202:
                return GET_NOTICECENTER_NOTICE_LIST;
            case 206:
                return GET_QUERY_PRICE_LIST_CONFIG;
            case 207:
                return VISITOR_LOGIN_SUCCESS;
            case 208:
                return VISITOR_LOGIN_FAILED;
            case 209:
                return EXCEED_VISITOR_QUERY_PRICE_LIMIT;
            case 211:
                return GET_NOTICE_DETAIL;
            case 214:
                return GET_DUIBA_URL_SUCCESS;
            case 215:
                return GET_DUIBA_URL_ERROR;
            case 216:
                return GET_LOGIN_STATUS;
            case 217:
                return GET_TEAM_NOTICE_DETAIL_SUCCESS;
            case 218:
                return GET_TEAM_NOTICE_DETAIL_ERROR;
            case 219:
                return GET_QA_LIST_SUCCESS;
            case 220:
                return GET_QA_LIST_ERROR;
            case 224:
                return GET_MAIN_SQUARE_GET_CUSTOMER_ARTICLE_LIST;
            case 225:
                return GET_MAIN_SQUARE_GET_CUSTOMER_BANNER;
            case 226:
                return GET_MAIN_SQUARE_ADD_NEW_MEMBER_LIST;
            case 227:
                return GET_MAIN_SQUARE_ADD_NEW_MEMBER_BANNER;
            case 230:
                return BIND_EMAIL_SUCCESS;
            case 231:
                return BIND_EMAIL_ERROR;
            case 232:
                return GET_PORTRAIT_URL_SUCCESS;
            case 233:
                return GET_PORTRAIT_URL_ERROR;
            case 234:
                return GET_BUSINESS_CARD_SHARE_INFO_SUCCESS;
            case 235:
                return GET_BUSINESS_CARD_SHARE_INFO_ERROR;
            case 238:
                return GENERATE_EXPERIENCE_STATION_URL;
            case 240:
                return GET_CAR_INFO_FOR_RENEW;
            case 241:
                return NETWORK_AVAILABLE;
            case 243:
                return GET_CERTS_AND_CHECK_CAR_IMAGES_SUCCESS;
            case 244:
                return GET_CERTS_AND_CHECK_CAR_IMAGES_FAILED;
            case 245:
                return SUBMIT_VEHICLE_CAR_PHOTO_SUCCESS;
            case 246:
                return SUBMIT_VEHICLE_CAR_PHOTO_ERROR;
            case 247:
                return GET_IMAGE_RECOGNITION_INFO_SUCCESS;
            case 248:
                return GET_IMAGE_RECOGNITION_INFO_ERROR;
            case 249:
                return GET_CUStOMER_EXISTENCE_SUCCESS;
            case 250:
                return GET_CUSTOMER_EXISTENCE_ERROR;
            case 251:
                return CUSTOMER_SEARCH_SUCCESS;
            case 252:
                return CUSTOMER_SEARCH_ERROR;
            case 253:
                return GET_CUSTOMER_DETAIL_SUCCESS;
            case 254:
                return GET_CUSTOMER_DETAIL_ERROR;
            case 255:
                return GET_VEHICLE_INSURANCE_DETAIL_SUCCESS;
            case 256:
                return GET_VEHICLE_INSURANCE_DETAIL_ERROR;
            case 257:
                return GET_HISTORY_POLICY_SUCCESS;
            case 258:
                return GET_HISTORY_POLICY_ERROR;
            case 259:
                return CUSTOMER_ADD_CAR_INFO_SUCCESS;
            case 260:
                return CUSTOMER_ADD_CAR_INFO_ERROR;
            case 261:
                return CUSTOMER_UPDATE_CUSTOMER_INFO_SUCCESS;
            case 262:
                return CUSTOMER_UPDATE_CUSTOMER_INFO_ERROR;
            case 263:
                return CUSTOMER_UPDATE_CAR_INFO_SUCCESS;
            case 264:
                return CUSTOMER_UPDATE_CAR_INFO_ERROR;
            case 265:
                return CUSTOMER_DEL_CUSTOMER_SUCCESS;
            case 266:
                return CUSTOMER_DEL_CUSTOMER_ERROR;
            case 267:
                return CUSTOMER_DEL_CAR_SUCCESS;
            case 268:
                return CUSTOMER_DEL_CAR_ERROR;
            case 269:
                return CUSTOMER_ADD_CUSTOMER_BASE_INFO_SUCCESS;
            case 270:
                return CUSTOMER_ADD_CUSTOMER_BASE_INFO_ERROR;
            case 271:
                return CUSTOMER_ADD_CUSTOMER_INFO_WITH_CAR_SUCCESS;
            case 272:
                return CUSTOMER_ADD_CUSTOMER_INFO_WITH_CAR_ERROR;
            case 273:
                return CUSTOMER_SPECIAL_HANDLE_ADD_CAR_SUCCESS;
            case 274:
                return SUBMIT_FEEDBACK_SUCCESS;
            case 275:
                return GET_TEAM_MEMBER_LIST_ERROR;
			case 276:
                return GET_TEAM_REPORT_SUCCESS;
            case 277:
                return GET_TEAM_REPORT_ERROR;
            case 278:
                return DAILY_SIGN_SUCCESS;
            case 279:
                return SEARCH_CAR_TYPE_SUCCESS;
            case 280:
                return ADD_CAR_SUCCESS;
            case 281:
                return GET_USER_MESSAGE_DETAIL;
            case 283:
                return UNDERWRITE_RESULT_NORMAL;
            case 284:
                return UNDERWRITE_RESULT_DUPLICATE_ORDER;
            case 285:
                return UNDERWRITE_RESULT_EXCEPTION;
            case 286:
                return DELETE_ORDER_SUCCESS;
            case 287:
                return MAIN_PAGE_SHARE;
            case 288:
                return CUSTOMER_ADD_CAR_HAS_DUPLICATE_CAR;
            case 289:
                return CUSTOMER_ADD_HAS_DUPLICATE_CUSTOMER;
            case 290:
                return GET_SHOW_BONUS_CONFIG;
            case 291:
                return SET_SHOW_BONUS_CONFIG_SUCCESS;
            case 292:
                return SET_SHOW_BONUS_CONFIG_FAILED;
            case 293:
                return GET_MAINPAGE_DATA_SUCCESS;
            case 294:
                return GET_MAINPAGE_DATA_FAIL;
            case 295:
                return GET_MAINPAGE_MARQUESS_LIST_SUCCESS;
            case 296:
                return GET_TEAM_MEMBER_ORDER_LIST_SUCCESS;
            case 297:
                return GET_TEAM_MEMBER_ORDER_LIST_ERROR;
            case 298:
                return GET_TEAM_QUERY_RESULTS_SUCCESS;
            case 299:
                return GET_TEAM_QUERY_RESULTS_ERROR;
            case 300:
                return GIFT_INSURANCE_SUCCESS;
            case 301:
                return GIFT_INSURANCE_FAIL;
            case 302:
                return UNDERWRITE_RESULT_DUPLICATE_ORDER_SAME_COMPANY;
            case 303:
                return GIFT_INSURANCE_ACCOUNT_REGISTERED;
            case 304:
                return UPDATE_TEAM_INFO_ERROR;
            case 305:
                return GET_TEAM_DETAILS_ERROR;
            case 306:
                return GENERATE_COMMON_REFEREE_URL_SUCCESS;
            case 307:
                return GET_TQ_INFO;
            case 308:
                return GIFT_INSURANCE_CANT_REPEAT_TO_RECEIVE;
            case 309:
                return SHARE_SUCCESS;
            case 310:
                return SET_NOTICE_CENTER_CAR_INSURANCE_POLICY_HAS_READ_SUCCESS;
            case 311:
                return SET_NOTICE_CENTER_ACTIVITY_HAS_READ_SUCCESS;
            case 312:
                return SET_NOTICE_CENTER_NOTICE_HAS_READ_SUCCESS;
            case 313:
                return SET_NOTICE_CENTER_CAR_INSURANCE_POLICY_ALL_READ_SUCCESS;
            case 314:
                return SET_NOTICE_CENTER_ACTIVITY_ALL_READ_SUCCESS;
            case 315:
                return SET_NOTICE_CENTER_NOTICE_ALL_READ_SUCCESS;
            case 316:
                return NOTICE_CENTER_REQUEST_FAIL;
            case 317:
                return GET_MINE_INFO_SUCCESS;
            case 318:
                return GET_MINE_INFO_ERROR;
            case 319:
                return APP_HAS_NOT_UPDATE;
            case 320:
                return CUSTOMER_GET_ALL_CUSTOMER_SUCCESS;
            case 321:
                return CUSTOMER_GET_ALL_CUSTOMER_ERROR;
            case 322:
                return CUSTOMER_IMPORT_CUSTOMER_SUCCESS;
            case 323:
                return CUSTOMER_IMPORT_CUSTOMER_ERROR;
            case 324:
                return CUSTOMER_IMPORT_CUSTOMER_PART_SUCCESS;
            case 325:
                return GET_RECORD_STATUS_SUCCESS;
            case 326:
                return AGENT_RECORD_COMMIT_INFO_SUCCESS;
            case 327:
                return AGENT_RECORD_COMMIT_INFO_FAIL;
            case 328:
                return PUT_ON_RECORD_SUCCESS;
            case 329:
                return CUSTOMER_UPDATE_CAR_ID_NO_SUCCESS;
            case 330:
                return CUSTOMER_UPDATE_CAR_ID_NO_ERROR;
            case 331:
                return GET_ACCIDENT_INSURANCE_LIST_SUCCESS;
            case 332:
                return GET_ACCIDENT_INSURANCE_FILTER_DATA_SUCCESS;
            case 333:
                return WITHDRAWAL_FINISH;
            case 334:
                return WITHDRAW_BY_BANKCARD_FIRST_COMMIT_SUCCESS;
            case 335:
                return WITHDRAW_BY_BANKCARD_FIRST_COMMIT_FAIL;
            case 336:
                return WITHDRAW_BY_BANKCARD_SECOND_COMMIT_SUCCESS;
            case 337:
                return WITHDRAW_BY_BANKCARD_SECOND_COMMIT_FAIL;
            case 338:
                return GET_WALLET_INCOME_DETAILS_FAIL;
            case 339:
                return GET_WALLET_OUTCOME_DETAILS_FAIL;
            case 340:
                return GET_MY_ORDER_ALL_LIST_SUCCESS;
            case 341:
                return GET_MY_ORDER_ALL_LIST_FAIL;
            case 342:
                return GET_MY_ORDER_PENDING_PAYMENT_LIST_SUCCESS;
            case 343:
                return GET_MY_ORDER_PENDING_PAYMENT_LIST_FAIL;
            case 344:
                return GET_MY_ORDER_COMPLETED_LIST_SUCCESS;
            case 345:
                return GET_MY_ORDER_COMPLETED_LIST_FAIL;
            case 346:
                return CAR_INSURANCE_GET_ADDRESS_SUCCESS;
            case 347:
                return CAR_INSURANCE_GET_ADDRESS_FAIL;
			case 348:
                return GET_TEAM_MEMBER_DETAIL_SUCCESS;
            case 349:
                return GET_TEAM_MEMBER_DETAIL_ERROR;
			case 350:
                return GET_WALLET_FROZEN_LIST_SUCCESS;
            case 351:
                return GET_WALLET_FROZEN_LIST_FAIL;
            case 352:
                return GET_WALLET_FROZEN_DONATE_ID_SUCCESS;
            case 353:
                return GET_WALLET_FROZEN_DONATE_ID_FAIL;
            case 354:
                return QUERY_CAR_INSURANCE_ORDER_INFO_SUCCESS;
            case 355:
                return QUERY_CAR_INSURANCE_ORDER_INFO_FAIL;
            case 356:
                return WALLET_FROZEN_REVOCATION_SUCCESS;
            case 357:
                return WALLET_FROZEN_REVOCATION_FAIL;
            case 358:
                return GET_JOINED_INVITATION_SUCCESS;
            case 359:
                return GET_JOINED_INVITATION_ERROR;
            case 360:
                return GET_NOT_JOINED_INVITATION_SUCCESS;
            case 361:
                return GET_NOT_JOINED_INVITATION_ERROR;
            case 362:
                return GET_GROUP_MEMBER_INFO_SUCCESS;
            case 363:
                return GET_GROUP_MEMBER_INFO_ERROR;
            case 364:
                return GET_PREMIUM_RANK_SUCCESS;
            case 365:
                return SEND_TEAM_INVITE_ERROR;
            case 366:
                return GET_PREMIUM_RANK_ERROR;
            case 367:
                return REQUEST_COMPANY_LIST_SUCCESS;
            case 368:
                return REQUEST_COMPANY_LIST_FAIL;
            case 369:
                return COMMIT_INSURED_ADDRESS_SUCCESS;
            case 370:
                return COMMIT_INSURED_ADDRESS_FAIL;
            case 371:
                return UNDERWRITE_RESULT_FAIL;
            case 372:
                return GENERATE_COMMON_REFEREE_URL_FAIL;
            case 373:
                return APP_UPDATE_SUCCESS;
            case 374:
                return GET_CREATE_GROUP_CLAIM_SUCCESS;
            case 375:
                return GET_CREATE_GROUP_CLAIM_ERROR;
            case 376:
                return TEAM_SEARCH_GROUP_SUCCESS;
            case 377:
                return TEAM_SEARCH_GROUP_ERROR;
            case 378:
                return JOIN_TEAM_SUCCESS;
            case 379:
                return JOIN_TEAM_ERROR;
            case 382:
                return QUICK_JOIN_TEAM_SUCCESS;
            case 383:
                return QUICK_JOIN_TEAM_ERROR;
            case 384:
                return GET_CAR_PRICE_HISTORY_SUCCESS;
            case 385:
                return GET_CAR_PRICE_HISTORY_ERROR;
            case 386:
                return SEARCH_CAR_TYPE_FAIL;
            case 387:
                return GET_OIL_CARD_CONFIG_SUCCESS;
            case 388:
                return GET_OIL_CARD_CONFIG_ERROR;
            case 389:
                return ADD_CUSTOM_MODEL_SUCCESS;
            case 390:
                return ADD_CUSTOM_MODEL_FAIL;
            case 391:
                return POST_RECORD_BLACK_USER_SUCCESS;
            case 392:
                return POST_RECORD_BLACK_USER_ERROR;
            case 393:
                return WITHDRAW_INSERT_BANK_CARD_SUCCESS;
            case 394:
                return WITHDRAW_INSERT_BANK_CARD_ERROR;
            case 395:
                return GET_BANK_LIST_SUCCESS;
            case 396:
                return GET_BANK_LIST_ERROR;
            case 397:
                return GET_WITHDRAW_BASE_INFO_SUCCESS;
            case 398:
                return GET_WITHDRAW_BASE_INFO_ERROR;
            case 399:
                return GET_ALL_BANK_LIST_SUCCESS;
            case 400:
                return GET_ALL_BANK_LIST_ERROR;
            case 401:
                return GET_NAME_AUTH_INFO_FAIL;
            case 402:
                return GET_LATEST_QUERY_CAR_INFO_SUCCESS;
            case 403:
                return GET_LATEST_QUERY_CAR_INFO_FAIL;
            case 404:
                return GET_ALL_LATEST_QUERY_CAR_INFO_SUCCESS;
            case 405:
                return GET_ALL_LATEST_QUERY_CAR_INFO_FAIL;
            case 406:
                return QUERY_CAR_INFO_SUCCESS_NEW;
            case 407:
                return QUERY_CAR_INFO_FAIL_NEW;
            case 408:
                return GET_PAGE_PARAMS_CONFIG_SUCCESS;
            case 409:
                return GET_PAGE_PARAMS_CONFIG_ERROR;
            case 410:
                return ADD_OR_UPDATE_CAR_INFO_SUCCESS;
            case 411:
                return ADD_OR_UPDATE_CAR_INFO_ERROR;
            case 412:
                return GET_ORDER_STATUS_SUCCESS;
            case 413:
                return GET_ORDER_STATUS_ERROR;
            case 414:
                return GET_PRICE_TO_ARTIFICIAL_PRICE;
            case 415:
                return SELECT_INS_AGENCY_JUMP_INSURANCE_INFO;
            default:
                return null;
        }
    }
}