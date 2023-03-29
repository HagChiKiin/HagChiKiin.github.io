-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2023 at 07:00 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_final`
--

-- --------------------------------------------------------

--
-- Table structure for table `curriculum_vitaes`
--

CREATE TABLE `curriculum_vitaes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `curriculum_vitaes`
--

INSERT INTO `curriculum_vitaes` (`id`, `user_id`, `name`, `content`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'thành đạt', 'https://www.topcv.vn/images/cv/screenshots/vi/passion.png', '2023-03-29 16:20:45', NULL, NULL),
(2, 2, 'tham vọng', 'https://www.topcv.vn/images/cv/screenshots/vi/ambitious.png', '2023-03-29 16:20:58', NULL, NULL),
(3, 9, 'thanh lịch', 'https://www.topcv.vn/images/cv/screenshots/vi/passion.png', '2023-03-29 16:21:05', NULL, NULL),
(4, 10, 'đam mê', 'https://www.topcv.vn/images/cv/screenshots/vi/basic_3_v2.png', '2023-03-29 16:21:12', NULL, NULL),
(5, 11, 'chuyên gia', 'https://www.topcv.vn/images/cv/screenshots/vi/default_v2.png', '2023-03-29 16:21:17', NULL, NULL),
(6, 12, 'cao cấp', 'https://www.topcv.vn/images/cv/screenshots/vi/time.png', '2023-03-29 16:21:23', NULL, NULL),
(7, 13, 'sang trọng', 'https://www.topcv.vn/images/cv/screenshots/vi/experts.png', '2023-03-29 16:21:29', NULL, NULL),
(8, 14, 'nhẹ nhàng', 'https://www.topcv.vn/images/cv/screenshots/vi/onepage_elegant_v2.png', '2023-03-29 16:21:43', NULL, NULL),
(9, 1, 'tiêu chuẩn', 'https://www.topcv.vn/images/cv/screenshots/vi/default_v2.png', '2023-03-29 16:22:05', NULL, NULL),
(10, 1, 'cổ điển', 'https://www.topcv.vn/images/cv/screenshots/vi/basic_1_v2.png', '2023-03-29 16:22:13', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employers`
--

CREATE TABLE `employers` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `employer_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `recruitment` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `introduce` text DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `startDate` varchar(20) DEFAULT NULL,
  `endDate` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employers`
--

INSERT INTO `employers` (`id`, `user_id`, `employer_id`, `name`, `recruitment`, `address`, `introduce`, `image`, `startDate`, `endDate`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 3, 1, 'Công Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt', 1, '82/15 Đường số 2, Khu phố 6, Phường Hiệp Bình Phước, Thành phố Thủ Đức, Thành phố Hồ Chí Minh\',', 'Câu Chuyện Thành Lập Công Ty\nCông Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) được thành lập bởi CEO Phạm Đăng Hưng. Đây là một công ty chuyên cung cấp các dịch vụ in ấn cho doanh nghiệp vừa và nhỏ.\n\nCông Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) chính thức được thành lập vào ngày 15/1/2015 dưới sự cố gắng, nỗ lực nhiều năm của ông Phạm Đăng Hưng. Từ rất lâu, ông Phạm Đăng Hưng đã nuôi dưỡng ước mơ có thể tự thành lập cho riêng mình một công ty. Chính vì vậy, ngay sau khi lấy được tấm bằng cử nhân, ông đã bắt đầu lên kế hoạch học tập nâng cao, trau dồi hoàn thiện kỹ năng bản thân cũng như tích lũy kinh nghiệm làm việc.\n\nSau khi đã trải qua không ít khó khăn, đau đầu đứng trước nhiều lựa chọn về việc theo đuổi lĩnh vực kinh doanh, mô hình nào. Đặc biệt là giải quyết về vấn đề tài chính. Cuối cùng, In Siêu Tốc cũng đã chính thức được ra đời với một quy mô chuyên nghiệp, dịch vụ chất lượng, hoàn thiện và tối ưu nhất.\n\nSứ Mệnh Công Ty\nLà một công ty chuyên cung cấp dịch vụ in ấn, In Siêu Tốc mang trên vai sứ mệnh cung cấp dịch vụ in ấn chất lượng, chuyên nghiệp dành cho các doanh nghiệp vừa và nhỏ tại Việt Nam, giúp doanh nghiệp sở hữu những bản in tốt nhất.\n\nTầm Nhìn Công Ty\nCông Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) mong muốn có thể trở thành đối tác hàng đầu của các doanh nghiệp vừa và nhỏ tại TP. Hồ Chí Minh trong lĩnh vực in ấn. Để làm được điều này công ty luôn chủ động cập nhật những công nghệ in ấn và trang thiết bị hiện đại để có thể nâng cao chất lượng dịch vụ.\n\nĐịnh Hướng Phát Triển Công Ty\nTrước khi Công Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) chính thức được ra đời, CEO Phạm Đăng Hưng đã lên kế hoạch định hướng phát triển chi tiết cho công ty của mình. Trong đó, kế hoạch này được chia làm 2 giai đoạn là phát triển ngắn trong vòng 5 năm đầu tiên và phát triển lâu dài trong vòng 10 năm tiếp theo. Cụ thể:\n\nTrong 2 năm đầu tiên đi vào hoạt động In Siêu Tốc sẽ đi theo định hướng phát triển “chậm mà chắc”. Công ty tích cực ghi nhận những phản hồi của khách hàng để có thể ngày càng cải thiện quy trình, chất lượng dịch vụ và phục vụ\nTiếp đó, đẩy mạnh các chiến dịch quảng cáo thương hiệu để giúp Công Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) ngày càng trở nên quen thuộc, gần gũi với khách hàng. Đồng thời có thể mở rộng phạm vi hoạt động ra ít nhất 1 chi nhánh nữa\nĐưa Công Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) trở thành lựa chọn số #1 trong lòng khách hàng, đặc biệt là các doanh nghiệp vừa và nhỏ mỗi khi nghĩ tới dịch vụ in ấn chất lượng\nVới định hướng phát triển rõ ràng cùng một tầm nhìn rộng, Công Ty TNHH Sản Xuất Thương Mại Dịch Vụ Hoa Sen Việt (In Siêu Tốc) trong những năm qua không ngừng cố gắng, nỗ lực vươn lên và thực sự đã đạt được những thành công nhất định. Hiện công ty đã trở thành đối tác quan trọng của nhiều doanh nghiệp tại TP. Hồ Chí Minh. Hy vọng rằng, trong tương lai, số lượng đối tác của công ty sẽ không ngừng gia tăng và ngày càng khẳng định được vị thế, chỗ đứng của mình trong lĩnh vực in ấn chuyên nghiệp.', 'https://insieutoc.vn/wp-content/uploads/2021/11/in-sieu-toc-vn-banner-web-01-2048x697.jpg', 'thứ 2', 'sáng thứ 7', '2023-03-29 16:27:34', '2023-03-29 16:34:15', NULL),
(2, 4, 2, 'CÔNG TY CỔ PHẦN TƯ VẤN BẤT ĐỘNG SẢN ĐỨC VIỆT', 2, 'Tòa Nhà Bảo Hân - P302, Số 66, Ngõ 34, Hoàng Cầu, Đống Đa, Hà Nội\', \'Nhân Viên Kinh Doanh / Tư Vấn/ Sale Tại Hà Nội', 'Trải qua gần 10 năm phát triển, Công Ty BĐS Đức Việt dần tạo được chỗ đứng cũng như uy tín trên thị trường Bất động sản. Tư Vấn Mua Bán và Cho thuê Các Bất Động Sản.\r\n\r\nCông ty Cổ Phần Tư Vấn Bất Động Sản Đức Việt Chuyên Tư Vấn Bán Căn Hộ Chung Cư, Nhà Riêng, Nhà Phố, Sàn Văn Phòng Thương Mại và cho thuê , vị trí đắc địa, văn phòng Hạng A, B, C, D, văn phòng Mini, và các sản phẩm dịch vụ bất động sản đa dạng và phong phú: Căn hộ Cao cấp, Căn hộ dịch vụ cho người nước ngoài, Nhà Riêng,\r\n\r\nTẦM NHÌN\r\n\r\nĐưa thương hiệu Đức Việt Land trở thành thương hiệu mạnh trên thị trường bất động sản.\r\n\r\nTập trung đào tạo và phát triển nguồn nhân lực để Khách hàng có sự tin tưởng đến các Sản Phẩm Công Ty đanng cho thuê Mua, Bán Môi giới và phân phối trực tiếp các dự án bất động sản cao cấp.\r\n\r\nMở rộng quy mô hoạt động trong các lĩnh vực đầu tư, kinh doanh, môi giới những sản phẩm bất động sản có chất lượng và dịch vụ cao.\r\n\r\nSỨ MỆNH\r\n\r\nTrở thành Công ty kinh doanh và dịch vụ bất động sản chuyên nghiệp hàng đầu, có tiềm lực về kinh tế, uy tín về chuyên môn. Khẳng định những sản phẩm và dịch vụ do Đức Việt Land cung cấp là hoàn hảo nhất. Lấy hiệu quả đầu tư, sự hài lòng của khách hàng làm phương châm hoạt động đem lại sự phát triển bền vững cho công ty. Tạo lập một môi trường làm việc thân thiện, chuyên nghiệp và có cơ hội phát triển nghề nghiệp cho các thành viên chiến lược và nhân viên trong công ty.\r\n\r\nMang lại giá trị tốt nhất cho khách hàng.\r\n\r\nNgười bạn đồng hành của đối tác\r\n\r\nGIÁ TRỊ CỐT LÕI\r\n\r\nTài sản lớn nhất của Đức Việt Land không phải là dòng tiền, cơ sở vật chất mà chính là đội ngũ nguồn nhân lực. Chúng tôi luôn coi trọng sự phát triển về năng - trí - thể lực của các thành viên. Phát triển đội ngũ nguồn nhân lực chính là tạo đôi cánh vững chắc cho sự phát triển bền vững tổ chức. Chúng tôi xây dựng chính sách đãi ngộ minh bạch, công tâm, cạnh tranh với thị trường, lộ trình thăng tiến được hoạch định sẵn nhằm thu hút và giữ chân nhân tài\r\n\r\nVăn Hóa Doanh Nghiệp -> Định hướng Phát triển doanh nghiệp đó là điều Công Ty BĐS Đức Việt Land đang hướng tới.\r\n\r\nPhương châm của Đức Việt Land “Niềm Tin hiện tại – Giá trị tương lai”, Đức Việt Land luôn hướng đến lợi ích của khách hàng, Các nhà đầu tư, Chủ nhà để có những Sản Phẩm Bất Động Sản Bán và Cho Thuê nhanh nhất.\r\n\r\nĐức Việt Land là nơi hội tụ những lãnh đạo - quản lý có tầm nhìn, có tâm huyết và hoài bão cùng với đội ngũ nhân viên năng động, chuyên nghiệp, nhiều kỹ năng, được đào tạo bài bản và không ngừng học hỏi để nâng cao trình độ chuyên môn, nhiều kinh nghiệm trong lĩnh vực bất động sản.\r\n\r\nHơn thế nữa, Đức Việt Land tạo điều kiện, môi trường để cho các bạn trẻ, những ai còn đang phân vân chưa định hướng được hướng đi của mình trong công việc có được một môi trường năng động, sáng tạo, chuyên nghiệp trải nghiệm các kỹ năng thông qua những gì học được trong quá trình làm việc tại đây.', 'https://ducvietland.vn/upload/img/banner/z2696576629514-9143fd37218f16e3dbe60277e15999ea.jpg', 'thứ 2', 'sáng thứ 7', '2023-03-29 16:26:40', '2023-03-29 16:38:34', NULL),
(3, 5, 3, 'Công ty Cổ phần Vietmap Hà Nội', 3, 'Hà Nội: 98-100 Khương Đình, Phường Hạ Đình, Thanh Xuân\\r\\n- Nghệ An: 42 Mai Hắc Đế, TP Vinh\\r\\n- Hồ Chí Minh: Số 3 Trần Nhân Tôn, Phường 9, Quận 5', 'Công ty Cổ phần Vietmap Hà Nội được thành lập vào năm 2010 bởi các chuyên gia có trình độ cao, nhiều năm kinh nghiệm trong lĩnh vực GIS (Geographic Information System - hệ thống thông tin địa lý) và công nghệ thông tin.\r\n\r\nHiện nay, VIETMAP được biết đến như một trong những công ty hàng đầu của Việt Nam về bản đồ số, cung cấp các dịch vụ và giải pháp ứng dụng GIS. VIETMAP cung cấp nhiều sản phẩm và giải pháp khác nhau cho hai nhóm đối tượng khách hàng là người tiêu dùng và doanh nghiệp\r\n\r\nSản phẩm cho người tiêu dùng:\r\n\r\nPhầm mềm bản đồ cho điện thoại di động chạy hệ điều hành WM, Symbian, Android.\r\n\r\nThiết bị GPS dẫn đường cầm tay\r\n\r\nThiết bị dẫn đường tích hợp với các màn hình có sẵn trong xe ô tô hoặc phần mềm cho xe ô tô đã có sẵn màn hình và chức năng GPS.\r\n\r\nHệ thống GPS Security chống trộm xe cho phép theo dõi vị trí xe hay tắt máy xe từ xa qua điện thoại di động.\r\n\r\nSản phẩm dùng cho doanh nghiệp:\r\n\r\nHệ thống GPS Tracking theo dõi và quản lý xe. Người quản lý đội xe ở bất cứ đâu có thể dùng máy tính để biết vị trí xe hiện tại, lộ trình xe đã đi qua, kiểm tra các thông số như tốc độ, xăng dầu, lịch bảo trì...\r\n\r\nPhần mềm và bản đồ GPS Engine dùng để tích hợp với các thiết bị dẫn đường xách tay cho nhà sản xuất khác nhau.\r\n\r\nCác giải pháp ứng dụng GIS được xây dựng riêng phù hợp với nhu cầu đặc thù của từng khách hàng như quản lý đất đai, hệ thống cửa hàng, các trạm thu phát sóng.', 'https://bizweb.dktcdn.net/100/415/690/themes/804206/assets/slider_2.jpg?1679910292058', 'thứ 2', 'sáng thứ 7', '2023-03-29 16:26:52', '2023-03-29 16:38:54', NULL),
(4, 6, 4, 'CÔNG TY CỔ PHẦN THIẾT BỊ BƯU ĐIỆN', 4, 'Số 61, phố Trần Phú, Phường Điện Biên, Quận Ba Đình, Thành phố Hà Nội, Việt Nam\', \'Nhân Viên Hành Chính Lễ Tân', '', '', 'thứ 2', 'thứ 6', '2023-03-29 16:27:00', '2023-03-29 16:39:09', NULL),
(5, 7, 5, 'CÔNG TY CỔ PHẦN GIẢI PHÁP VÀ CÔNG NGHỆ VIETNIX', 5, '265 Hồng Lạc, Phường 10, Quận Tân Bình, Thành phố Hồ Chí Minh, Việt Nam', 'Công ty Cổ phần giải pháp và Công nghệ Vietnix\r\n\r\nThành lập từ năm 2012, Vietnix đã trải qua gần 10 năm xây dựng và phát triển trong lĩnh vực Hosting. Vietnix là dịch vụ máy chủ đầu tiên tại Việt Nam tập trung phát triển công nghệ chống DDoS chuyên nghiệp.\r\nVietnix là công ty tin học trẻ chuyên nghiệp trong lĩnh vực hệ thống máy chủ, cho thuê hosting, máy chủ ảo (VPS), máy chủ vật lý, dịch vụ quản trị máy chủ, dịch vụ bảo mật máy chủ. Với đội ngũ kỹ sư lành nghề và tận tâm, Vietnix luôn cam kết mang lại dịch vụ ổn định và chất lượng nhất cho khách hàng.\r\nUy tín - Chất lượng - Hiệu quả\r\n\r\nCho đến thời điểm hiện tại, đã có hơn 40.000 khách hàng tin tưởng sử dụng dịch vụ của Vietnix, trong đó có các khách hàng lớn như GTV, Vietnamworks, UB Group...\r\nVới đội ngũ hơn 60 nhân sự chuyên nghiệp luôn sẵn sàng phục vụ, Vietnix cam kết đem đến cho khách hàng và đối tác sự hài lòng nhất.', 'https://vietnix.vn/wp-content/uploads/2023/01/ct-desktop.png', 'thứ 2', 'thứ 7', '2023-03-29 16:27:10', '2023-03-29 16:39:31', NULL),
(6, 8, 6, 'CÔNG TY CỔ PHẦN ĐẦU TƯ XÂY DỰNG KINH DOANH LỘC PHÚC', 6, 'Hồ Chí Minh: Số 34 Tiền Giang, Phường 2, Tân Bình\', \'Nhân Viên Lễ Tân Hành Chính', 'Nhằm hướng đến mục tiêu và tầm nhìn đóng góp vào sự phát triển của ngành bất động sản nói riêng và nền kinh tế Việt Nam nói chung, Công ty đang tự hào tạo ra một cầu nối chuẩn mực, đáng tin cậy cho hàng nghìn khách hàng tìm đến với các dự án trực thuộc Công ty và chủ đầu tư uy tín trên thị trường thông qua các dịch vụ: TƯ VẤN, QUẢNG BÁ, QUẢNG CÁO sản phẩm.\r\n\r\nBên cạnh đó, chúng tôi cung cấp giải pháp toàn diện giúp khách hàng và các nhà đầu tư nắm bắt được rõ hơn về các dự án của chủ đầu tư cũng như về chính sách đầu tư & tài chính liên quan đến lĩnh vực bất động sản. Vì vậy, Công ty  đã và đang trở thành một trong những đơn vị uy tín, đáng tin cậy trên thị trường bất động sản, với số lượng khách hàng lên tới hơn 1000 người trên khắp cả nước trong quá trình hình thành, xây dựng và phát triển:\r\n\r\nA/ TẦM NHÌN:\r\n\r\nPhấn đấu từng ngày để vươn lên trở thành một Doanh nghiệp hàng đầu Việt Nam và khu vực, hướng đến một thương hiệu đẳng cấp Quốc tế trong lĩnh vực Bất động sản.\r\n\r\nB/ SỨ MỆNH:\r\n\r\n“NGƯỜI ĐỒNG HÀNH SỐ 1” của khách hàng: HỢP TÁC cùng phát triển - HƯỚNG VỀ CỘNG ĐỒNG VÀ LỢI ÍCH XÃ HỘI, TRÁCH NHIỆM VỚI CÔNG DÂN - MÔI TRƯỜNG LÀM VIỆC CHUYÊN NGHIỆP, SÁNG TẠO, TRẺ TRUNG\r\n\r\nGIÁ TRỊ CỐT LÕI:\r\n\r\nChúng tôi coi trọng chữ TÍN như chính danh dự của mình và luôn kinh doanh trên nền tảng TRUNG THỰC\"', 'https://static.topcv.vn/employer_medias/a662d865132bee816bafd116361e8d6f-634661f556241.jpg', 'thứ 2', 'thứ 7', '2023-03-29 16:27:17', '2023-03-29 16:39:40', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `evaluates`
--

CREATE TABLE `evaluates` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `employer_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `overallRating` varchar(10) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `updated_ad` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `evaluates`
--

INSERT INTO `evaluates` (`id`, `user_id`, `employer_id`, `title`, `content`, `overallRating`, `created_at`, `deleted_at`, `updated_ad`) VALUES
(1, 2, 1, 'Công ty không nên làm việc', 'Công ty đã lương thấp lại còn áp lực, sếp thì yêu cầu 1 đống việc nhưng chỉ trả có vài đồng bạc. Khuyên mọi người không nên làm ở đây', '0.5☆', '2023-03-08 06:23:30', NULL, NULL),
(2, 9, 2, 'Đoàn kết là sức mạnh', 'Công ty có đội ngũ nhân viên nhiệt tình, chế độ lương thưởng hấp dẫn.Công ty có nhiều hoạt động ngoại khóa để kết nối nhân viên. Đặc biệt với dàn nhân viên trẻ trung sẽ là điểm đến tuyệt vời dành cho các bạn trẻ trung và năng động. Hãy cùng tôi trải nghiệm', '5☆', '2023-02-07 03:47:13', NULL, NULL),
(3, 10, 3, 'Vietmap - đưa cả thế giới lại gần với bạn', 'Môi trường làm việc chuyên nghiệp, nhiều cơ hội thăng tiến.\\r\\nCác bạn nhân viên rất nhiệt tình và năng động\\r\\nChế độ lương thưởng rất hấp dẫn.', '4☆', '2022-11-09 04:20:44', NULL, NULL),
(4, 11, 4, 'chế độ đãi ngộ thấp', 'hế độ đãi ngộ thấp, đặc biệt là tiền xăng xe có 800k. không đủ nửa tiền xăng đi lại hàng tháng', '3☆', '2022-07-13 04:24:30', NULL, '2023-01-17 01:20:35'),
(5, 12, 5, 'Không nên làm việc tại công ty này', 'chế độ đãi ngộ thấp, chế độ lương thưởng thấp, yêu cầu với nhân viên nhiều, thời gian thử việc lâu', '0☆', '2022-12-13 03:47:19', NULL, NULL),
(6, 14, 6, 'Lương quá thấp', 'Chế độ lương quá thấp, lại yêu cầu cao hơn 1m6, lại còn cần ngoại hình ưa nhìn.\\r\\nThà làm phụ hồ còn lương cao hơn', '4☆', '2022-11-12 07:16:36', NULL, '2023-03-04 23:30:25');

-- --------------------------------------------------------

--
-- Table structure for table `recruitment_details`
--

CREATE TABLE `recruitment_details` (
  `id` int(11) NOT NULL,
  `employer_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `content` text DEFAULT NULL,
  `recruitment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `recruitment_details`
--

INSERT INTO `recruitment_details` (`id`, `employer_id`, `name`, `deadline`, `status`, `created_at`, `updated_at`, `deleted_at`, `content`, `recruitment_id`) VALUES
(1, 5, 'Nhân Viên Kinh Doanh (Lương Thưởng Hấp Dẫn) ', '2023-03-14', 'Còn tuyển', '2023-03-29 16:55:21', NULL, NULL, '\'Tư vấn, giải đáp mọi thắc mắc liên quan đến sản phẩm kinh doanh.\\r\\nTiếp nhận, cập nhật thông tin khách hàng, quản lý thông tin dữ liệu của khách hàng.\\r\\nBáo giá, hợp đồng, quản lý báo giá, hợp đồng bán hàng. Duy trì quan hệ kinh doanh hiện có với khách hàng.\\r\\nPhối hợp trong các hoạt động sales và marketing, gọi điện thoại quảng bá, giới thiệu các sự kiện, chương trình ưu đãi tới danh sách khách hàng tiềm năng được phân công.\\r\\nTheo dõi đơn hàng, hỗ trợ khách hàng giải quyết các vấn đề phát sinh với các đơn hàng.\\r\\nTheo dõi kế hoạch xuất hàng và tổng hợp đơn hàng.\\r\\nBáo cáo về hoạt động Sales và Marketing hàng tuần và hàng tháng.\\r\\nChuẩn bị tài liệu cho các cuộc họp nội bộ/bên ngoài.\\r\\nCác công việc khác theo yêu cầu được Quản lý phân công.\', \'Có khả năng telesale\\r\\nĐộ tuổi: 20 – 28\\r\\nKỹ năng: Sử dụng Office văn phòng cơ bản, kỹ năng xử lý số liệu, làm báo cáo, và biết khai thác internet, làm việc theo nhóm.\\r\\nĐam mê kinh doanh, năng động, có trách nhiệm với công việc.\\r\\nGiao tiếp tốt, trung thực, phát âm rõ ràng.\\r\\nNhiệt tình, nhanh nhạy trong công việc, có khả năng chịu được áp lực công việc.\\r\\nCó kinh nghiệm làm việc trong mảng CNTT, kinh doanh dịch vụ hosting là 1 lợi thế.\', \'Thử việc: 2 tháng.\\r\\nThời gian làm việc: Giờ hành chính\\r\\nCơ hội huấn luyện:\\r\\nĐược học hỏi, đào tạo luôn không ngừng phát triển với nhiều cơ hội thăng tiến bản thân, phát triển lên các vị trí cao hơn trong hệ thống tổ chức.\\r\\nĐồng nghiệp:\\r\\nLàm việc trong môi trường chuyên nghiệp, năng động, nhiều cơ hội phát triển năng lực bản thân, đãi ngộ dựa trên năng lực và sự nhiệt tình sáng tạo của từng thành viên.\\r\\nNgày nghỉ: 12 ngày phép năm.\\r\\nPhúc lợi:\\r\\n- Lương tháng 13 và thưởng theo hiệu quả kinh doanh, cùng nhiều chế độ thưởng khác nhau.\\r\\n- Tham gia đầy đủ các chế độ BHYT, BHXH, BHTN.\\r\\n- Teambuilding 2 lần/năm, nghỉ các ngày lễ tết, dịp đặc biệt của công ty.\\r\\nPhụ cấp khác :Hỗ trợ ăn trưa, gửi xe.', 5),
(2, 4, 'Nhân Viên Hành Chính Lễ Tân', '2023-03-14', 'Còn tuyển', '2023-03-29 16:55:59', NULL, NULL, 'Quản lý hồ sơ, giấy tờ\\r\\n\\r\\n- Tiếp nhận các giao dịch với khách hàng bằng hai hình thức trực tiếp và trao đổi thông qua điện thoại.\\r\\n\\r\\n- Tiếp đón khách mời mỗi khi công ty có sự kiện hay hoạt động nội bộ.\\r\\n\\r\\n- Tổ chức các sự kiện của công ty và hoạt động vui chơi cho nhân viên nhằm duy trì và phát triển văn hóa nội bộ doanh nghiệp.\\r\\n\\r\\n- Chấm công hàng ngày cho các nhân viên của công ty; lên danh sách lương, thưởng mỗi tháng cho nhân viên và thanh toán tiền lương đúng hạn.\\r\\n\\r\\n- Quản lý hoạt động lưu giữ thông tin và cơ sở dữ liệu của nhân viên\\r\\n\\r\\n- Theo dõi máy móc, thiết bị liên quan đến tài sản của công ty, cũng như các thông tin liên quan tới vấn đề máy móc của nhân viên khác báo lại.\\r\\n\\r\\n- Có kế hoạch cần thiết để bảo dưỡng nhằm duy trì tiến độ làm việc thông thường cho nhân viên ở bộ phận sản xuất.\\r\\n\\r\\n- Kê khai các ấn phẩm văn phòng hàng tháng và thực hiện hoạt động mua cung cấp cho các phòng ban trong tổ chức\', \'- Kiến thức: Am hiểu các phương pháp làm việc trong lĩnh vực văn thư , hành chánh\\r\\n\\r\\n- Các kỹ năng đặc biệt: biết linh hoạt ứng xử các tình huống phát sinh trong tiếp xúc, hướng dẫn người đến liên hệ công tác.\\r\\n\\r\\n- Tố chất cần có:\\r\\n\\r\\n• Nhanh nhẹn, tháo vát, chịu được áp lực công việc cao.\\r\\n\\r\\n• Năng động hoạt bát, luôn tươi cười.\\r\\n\\r\\n• Hoà nhã, lịch thiệp.\\r\\n\\r\\n• Có tinh thần học hỏi\', \'- Làm việc thứ 2 đến thứ 6 , nghỉ thứ 7 và chủ nhật\\r\\n\\r\\n- Mức lương cạnh tranh – hấp dẫn, đánh giá năng lực hàng năm\\r\\n\\r\\n- Trợ cấp 800,000 xăng xe\\r\\n\\r\\n-  Tiền chuyên cần 1,000,000\\r\\n\\r\\n- Trợ cấp cơm trưa\\r\\n\\r\\n- Công ty đóng các loại BHXH\\r\\n\\r\\n- Được hưởng toàn bộ phúc lợi của công ty ( du lịch , liên hoan , nghỉ tết ,...)\\r\\n\\r\\n- Thưởng những ngày lễ , tết , sinh nhật, lương tháng 13 tết', 4),
(3, 2, 'Nhân Viên Kinh Doanh / Tư Vấn/ Sale (Thu Nhập 15-30 Triệu) Tại Hà Nội', '2023-04-10', 'Còn tuyển', '2023-03-29 16:56:23', NULL, NULL, 'Mở rộng danh sách khách hàng, chăm sóc tốt khách hàng đã có, khách hàng phát sinh\\r\\n\\r\\n● Lập kế hoạch kinh doanh cho cá nhân theo tuần, tháng, quý đáp ứng được các yêu cầu của công ty\\r\\n\\r\\n● Là người đại diện chuyên nghiệp của công ty hỗ trợ khách hàng tốt nhất.\\r\\n\\r\\n● Tư vấn cho thuê các Bất Động Sản Công ty đang Quản Lý.\\r\\n\\r\\n● Cho thuê các Căn hộ Chung Cư cao cấp cho các chuyên gia nước ngoài.\\r\\n\\r\\n● Cho thuê các tòa nhà Văn Phòng Hạng A,B,C,D 4 Quận Nội Thành Công ty đang quản lý\\r\\n\\r\\n● Cho Thuê Nhà riêng, Nhà Phố, Trung tâm thương mại....\\r\\n\\r\\n● Thời gian làm việc: Giờ hành chính, nghỉ chiều thứ 7 và ngày chủ nhật.\', \'● Không có kinh nghiệm sẽ được Đào tạo\\r\\n\\r\\n● Có Laptop cá nhân + phương tiện đi lại\\r\\n\\r\\n● Có kinh nghiệm trong lĩnh vực sale, sale bất động sản, chứng khoán, cổ phiếu là lợi thế.\\r\\n\\r\\n● Nam/nữ 20- 40 tuổi, lý lịch rõ ràng, nhanh nhẹn, giao tiếp tốt, yêu thích kinh doanh.\\r\\n\\r\\n● Tốt nghiệp trung cấp trở lên.\\r\\n\\r\\n● Khả năng giao tiếp tốt, làm việc độc lập, làm việc nhóm tốt.\\r\\n\\r\\n● Sức khỏe tốt, tính cách nhanh nhẹn, nhiệt tình, có trách nhiệm, kiên trì.\\r\\n\\r\\nƯu tiên:\\r\\n\\r\\n● Có kinh nghiệm làm Bất động sản, Có Xe Máy và Laptop…\\r\\n\\r\\n● Có kinh nghiệm trong lĩnh vực sale, sale bất động sản, chứng khoán, cổ phiếu là lợi thế\', \'● Lương CB từ 3,5 triệu đến 5 triệu/ tháng, không phụ thuộc doanh số.\\r\\n\\r\\n● Thu nhập 10 – 80 triệu/ tháng bao gồm thưởng nóng và hoa hồng giao dịch bất động sản.+ % Hoa hồng từ 30% đến 50%.\\r\\n\\r\\n● Thưởng và các chế độ khác theo quy định riêng của công ty.\\r\\n\\r\\n● Hưởng BHXH, BHYT theo quy định của luật lao động Việt Nam.\\r\\n\\r\\n● Môi trường làm việc năng động, chuyên nghiệp, thân thiện.\\r\\n\\r\\n● Công việc ổn định, ký hợp đồng dài hạn, tối đa hóa thu nhập.\\r\\n\\r\\n● Cơ hội giao lưu với các sàn bất động sản khác trên toàn Hà Nội.\\r\\n\\r\\n● Môi trường làm việc: năng động và chuyên nghiệp\\r\\n\\r\\n● Được đào tạo bài bản để trở thành một nhà môi giới Bất Động Sản chuyên nghiệp đúng nghĩa\'', 2),
(4, 6, 'Nhân Viên Lễ Tân Hành Chính(Không Yêu Cầu Kinh Nghiệm)', '2023-04-24', 'Còn tuyển', '2023-03-29 16:56:45', NULL, NULL, 'Trực, nghe, trả lời, chuyển cuộc gọi điện thoại tại quầy lễ tân của Công ty.\\r\\n- Đón tiếp khách hàng, ứng viên, sắp xếp phòng họp khi cần.\\r\\n- Quản lý văn phòng phẩm, đặt mua dụng cu khi cần thiết.\\r\\n- Trang trí công cty vào các ngày lễ tết. làm theo các yêu cầu khác của cấp trên.\\r\\n- Thời gian làm việc : Thứ 2 đến thứ 7, từ 8h30 -> 17h30, trưa nghĩ 1h30\\\" .\', \'- Nam/Nữ, LGBT.Tuổi từ 1993 – 2004 tuổi.\\r\\n\\r\\n- Ngoại hình ưa nhìn , chiều cao từ 1m6 trở lên.\\r\\n\\r\\n- Kỹ năng giao tiếp tốt.\\r\\n\\r\\n- Có kinh nghiệm là môt lợi thế.\\r\\n\\r\\n- Trình độ tin học văn phòng (nếu có).\\r\\n\\r\\n- Yêu cầu khác: Trung thực, giao tiếp tốt và thân thiện.\', \'- Thu nhập: 6triệu5 – 10 triệu (+ phụ cấp), thưởng.\\r\\n\\r\\n- Làm việc trong môi trường năng động\\r\\n\\r\\n- Được đào tạo miễn phí các kỹ năng để hoàn thành tốt công việc\\r\\n\\r\\n- Chế độ Bảo Hiểm đầy đủ sau 2 tháng thử việc, nghỉ Lễ Tết, Thưởng..', 6),
(5, 3, 'Nhân Viên Kinh Doanh - Thu Nhập Hấp Dẫn Từ 12-25 Triệu', '2023-04-18', 'Dừng tuyển', '2023-03-29 16:57:00', NULL, NULL, 'Hiện nay, VIETMAP được biết đến như một công ty hàng đầu của Việt Nam về bản đồ số, sản phẩm, dịch vụ và giải pháp ứng dụng GIS. Dựa trên sản phẩm cốt lõi là bản đồ số chi tiết, có độ chính xác cao của 63 tỉnh thành được cập nhật liên tục, chúng tôi phục vụ cho khách hàng là người tiêu dùng, doanh nghiệp sản phẩm và giải pháp khác nhau: phần mềm dẫn đường ô tô, thiết bị GPS dẫn đường & hệ thống GPS Tracking theo dõi và quản lý xe, giải pháp ứng dụng bản đồ...\\r\\n\\r\\nChúng tôi cần tìm người đam mê kinh doanh, sáng tạo cho vị trí NHÂN VIÊN KINH DOANH để phát triển thị trường về phần mềm dẫn đường, camera hành trình, thiết bị định vị để đem đến cho cộng đồng sản phẩm và dịch vụ tốt nhất.\', \'Tuổi từ 20 - 35 tuổi\\r\\nTốt nghiệp cao đẳng trở lên chuyên ngành quản trị kinh doanh, makerting, kinh tế là điểm cộng\\r\\nCó từ 1-3 năm kinh nghiệm ở vị trí sales, ưu tiên trong các lĩnh vực: Công nghệ, Ôtô, Giải pháp thiết bị,...\\r\\nCó khả năng giao tiếp, đàm phàn và thuyết phục khách hàng\\r\\nCó khả năng lập kế hoạch, quản lý thời gian, công việc\\r\\nChăm chỉ, trung thực và chịu được áp lực cao\\r\\nCó bằng lái xe ô tô là một lợi thế\', \'- Thu nhập hấp dẫn từ 12-25 triệu\\r\\n\\r\\n-Quyền lợi, chế độ khác:\\r\\n\\r\\n-Phép năm: 12 ngày/ năm tương ứng mỗi tháng 1 ngày nghỉ phép có lương\\r\\n-BHXH, BHYT, BHTN: Đầy đủ\\r\\n-Chế độ khác: Lương tháng 13, du lịch, thưởng lễ tết, sinh nhật …\\r\\n-Đào tạo: Được đề xuất training, đào tạo chuyên môn thuộc chức năng để phục vụ mục tiêu, nhiêm vụ được giao.\\r\\n-Môi trường làm việc: Môi trường làm việc chuyên nghiệp, nhiệt tình, năng động, nhiều cơ hội thăng tiến.\\r\\n-Thời gian làm việc:Từ 8h – 12h và từ 13h00 – 17h00 Từ thứ 2 – thứ 6 và sáng thứ 7\\r\\n\\r\\n- Thời gian thử việc: Tối đa 2 tháng', 3),
(6, 1, 'Nhân Viên Thiết Kế - Chế Bản In Ấn', '2023-04-10', 'Còn tuyển', '2023-03-29 16:57:13', NULL, NULL, 'Chuẩn file, bình file in nhanh, in offset.\\r\\n\\r\\n+ Thiết kế Marquette: bao bì, nhãn mác, tờ rơi, catalogue, túi giấy.... theo yêu cầu và mục đích sử dụng sản phẩm của khách hàng.\\r\\n\\r\\n+ Trao đổi ý tưởng thiết kế với khách hàng về sản phẩm; đảm bảo thời gian, tiến độ công việc, sản phẩm thiết kế của mình được giao.\\r\\n\\r\\n+ Giám sát và kiểm tra chất lượng của của các sản phẩm in ấn.\\r\\n\\r\\n+ Thực hiện các công việc khác theo sự phân công của Ban Giám đốc\', \'+ Có kinh nghiệm làm việc tại công ty in nhanh (kts) hoặc offset tối thiểu 1 năm.\\r\\n\\r\\n+ Nam/Nữ (Nếu nam là một lợi thế)\\r\\n\\r\\n+ Thành thạo PTS, AI, Corel,...\\r\\n\\r\\n+ Trung thực, chăm chỉ, chịu khó tiếp thu học hỏi.\\r\\n\\r\\n+ Đam mê với lĩnh vực thiết kế, tư duy thẩm mỹ tốt.\', \'+ Lương: 7-12 triệu (phụ thuộc vào khả năng sáng tạo, tư duy, sẽ trao đổi đánh giá khi hoàn thành bài test), thỏa thuận thêm khi đến phỏng vấn.\\r\\n\\r\\n+ Được làm việc trong môi trường năng động, thỏa sức sáng tạo, không bị gò bó\\r\\n\\r\\n+ Hưởng các chế độ đãi ngộ theo luật lao động như: BHXH, BHYT, BHTN …\\r\\n\\r\\n+ Thời gian làm việc: từ thứ 2 - thứ 6 và sáng thứ 7\\r\\n\\r\\n+ Lương tháng 13 + thưởng theo năng lực làm việc', 1),
(7, 5, 'Quản Trị Hệ Thống Junior ', '2023-04-14', 'Còn tuyển', '2023-03-29 16:57:25', NULL, NULL, 'Hỗ trợ khắc phục sự cố cho khách hàng khách hàng và quản lý hạ tầng.\\r\\nMôi trường làm việc tương đối áp lực, công việc hằng ngày được tiếp xúc: Quản trị máy chủ Linux, hệ thống web server, mail server; Hệ thống hosting (VestaCP, Cpanel); Hệ thống VPS ảo hóa Proxmox, VMware; Hệ thống proxy và tham gia chống DoS/DDoS, cơ hội tham gia phát triển Openstack cloud,...\\r\\nTham gia phát triển các công nghệ/công cụ phục vụ cho công việc, các dự án về triển khai và quản trị hệ thống theo yêu cầu.\\r\\nTính chất công việc: Theo ca được phân công (Ngày 3 ca làm việc: 8h00 - 16h00 , 16h00 - 0h00 và 0h00 - 8h00).\', \'Độ tuổi: 21 – 26\\r\\nNăng động, có trách nhiệm với công việc.\\r\\nGiao tiếp tốt, trung thực, phát âm rõ ràng.\\r\\nNhiệt tình, nhanh nhạy trong công việc, có khả năng chịu được áp lực công việc.\\r\\nSinh viên đang theo học hoặc tốt nghiệp lĩnh vực liên quan CNTT - KHMT, có đam mê và định hướng rõ ràng với công việc System Administrator, Linux System, Security và công việc quản trị hệ thống.\\r\\nSử dụng thành thạo Linux ở mức độ End User.\\r\\nNắm vững 1 ngôn ngữ lập trình bất kỳ (bash, python, php,..)\\r\\nƯu tiên các ứng viên có kinh nghiệm về triển khai LAMP/LEMP stack.\\r\\nCó kiến thức căn bản về network, qua đào tạo CCNA, CCNP,... là một lợi thế.\', \'Lương cơ bản: 6tr - 12tr tùy theo năng lực.\\r\\nHỗ trợ ăn trưa, gửi xe.\\r\\nTham gia đầy đủ các chế độ BHYT, BHXH, BHTN.\\r\\nXét tăng lương 2 lần/năm, lương tháng 13, cùng nhiều chế độ thưởng khác nhau.\\r\\nTeambuilding 2 lần/năm, nghỉ các ngày lễ tết, dịp đặc biệt của công ty.\\r\\nĐược học hỏi, đào tạo luôn không ngừng phát triển với nhiều cơ hội thăng tiến bản thân, phát triển lên các vị trí cao hơn trong hệ thống tổ chức.\\r\\nLàm việc trong môi trường chuyên nghiệp, năng động, nhiều cơ hội phát triển năng lực bản thân, đãi ngộ dựa trên năng lực và sự nhiệt tình sáng tạo của từng thành viên.', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `employers_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `employers_id`, `email`, `password`, `role`, `avatar`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, NULL, 'admin@gmail.com', '88e1ac580f1f02c188f82c384b537b5c', 'admin', 'https://taimienphi.vn/tmp/cf/aut/Uhun-IbFB-MnGE-DiPL-OCTB-hinh-dep-1.jpg', '2023-03-29 16:10:48', NULL, NULL),
(2, NULL, 'kien@gmail.com', '304e484fe25c741a3e3e67ad740d2a99', 'user', 'https://scontent.fhan5-10.fna.fbcdn.net/v/t1.6435-9/58444940_1775696015864170_2529676393780871168_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=174925&_nc_ohc=lcKodOY-U2wAX_ongrV&_nc_ht=scontent.fhan5-10.fna&oh=00_AfBG-QC10qOKyrxevIyVDEQz4oh0ZDXPYo5AO9OVu9AQNQ&oe=644', '2023-03-29 16:10:59', NULL, NULL),
(3, 1, 'hoasen@gmail.com', '82c220161207433e77c1174f8e78cb14', 'employer', 'https://cdn.topcv.vn/140/company_logos/daNjIByggsARn4D7oXqr0C6v3zlGrBVK_1632710437____3df8143efd7e44d1735add6f3c10c44e.PNG', '2023-03-29 16:14:06', NULL, NULL),
(4, 2, 'ducviet@gmail.com', '900ecae0a04af4e4e33b30bd03d1fa44', 'employer', 'https://cdn.topcv.vn/80/company_logos/cong-ty-co-phan-tu-van-bat-dong-san-duc-viet-641c17766152b.jpg', '2023-03-29 16:14:08', NULL, NULL),
(5, 3, 'vietmap@gmail.com', '7611adedf1648b4bf45c13e587db3688', 'employer', 'https://cdn.topcv.vn/80/company_logos/cong-ty-co-phan-vietmap-ha-noi-6417b9abae45b.jpg', '2023-03-29 16:14:11', NULL, NULL),
(6, 4, 'buudien@gmail.com', '855dd907d92fa52470e729a78009eb91', 'employer', 'https://www.topcv.vn/v4/image/topcv-logo-company-default.png', '2023-03-29 16:14:13', NULL, NULL),
(7, 5, 'vietnix@gmail.com', '589403554a71ec0f96416945462f103d', 'employer', 'https://cdn.topcv.vn/80/company_logos/cong-ty-co-phan-giai-phap-va-cong-nghe-vietnix-624e5b3f74427.jpg', '2023-03-29 16:14:15', NULL, NULL),
(8, 6, 'locphuc@gmail.com', '47099ef16730b7145557c53f1dc1eb3c', 'employer', 'https://cdn.topcv.vn/80/company_logos/gD9IypiWPjQCwdbqhrljaAX1LL1krhFW_1657848066____b9674b0097c1a290982e22a07d0f3342.jpg', '2023-03-29 16:16:21', NULL, NULL),
(9, NULL, 'taidao@gmail.com', '0555da41b7af07e3e5ab3a2da3f999b5', 'user', 'https://media.techmaster.vn/api/static/kSEHy2fm/8luVYBrH', '2023-03-29 16:13:05', NULL, NULL),
(10, NULL, 'xuananh@gmail.com\r\n', '2f0eca762c84d06bd57ac44d99ad5260', 'user', 'https://media.techmaster.vn/api/static/CMLEhVsl/z1v4W4xS', '2023-03-29 16:13:16', NULL, NULL),
(11, NULL, 'trong@gmail.com', '20fddbb3f72309a4ad742d0aaf84a546', 'user', NULL, '2023-03-29 16:13:24', NULL, NULL),
(12, NULL, 'thangdz@gmail.com', 'dd8a91a6f7d4248fdf4684d9683faa31', 'user', NULL, '2023-03-29 16:13:32', NULL, NULL),
(13, NULL, 'toandz@gmail.com', '180e0b3b4f388b53a3057695f383aa7f', 'user', NULL, '2023-03-29 16:13:41', NULL, NULL),
(14, NULL, 'locphuho@gmail.com', '850b12f96306750c262bb5239fb65310', 'user', NULL, '2023-03-29 16:13:51', NULL, NULL),
(15, 5, 'taiiiii@gmail.com', '4d0b6760d05637dc620930936f6f043f', 'employer\n', 'https://cdn.topcv.vn/80/company_logos/cong-ty-co-phan-giai-phap-va-cong-nghe-vietnix-624e5b3f74427.jpg', '2023-03-29 16:14:42', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `curriculum_vitaes`
--
ALTER TABLE `curriculum_vitaes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_curriculum_vitaes_users` (`user_id`);

--
-- Indexes for table `employers`
--
ALTER TABLE `employers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `evaluates`
--
ALTER TABLE `evaluates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recruitment_details`
--
ALTER TABLE `recruitment_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `curriculum_vitaes`
--
ALTER TABLE `curriculum_vitaes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `employers`
--
ALTER TABLE `employers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `evaluates`
--
ALTER TABLE `evaluates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `recruitment_details`
--
ALTER TABLE `recruitment_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `curriculum_vitaes`
--
ALTER TABLE `curriculum_vitaes`
  ADD CONSTRAINT `fk_curriculum_vitaes_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
