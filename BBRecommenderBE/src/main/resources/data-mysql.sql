use RecommenderDB;

-- make sure the video url is an embed url from youtube
-- This is achieved by going to Share/delen on a video and insluiten/Embed

/* insert Oracle Eloqua in database if not exist*/
INSERT INTO ToolDetailedInfo (toolName, toolVideoUrl, toolDescription)
SELECT 'Oracle Eloqua', 'https://www.youtube.com/embed/TV8e3Lc2tD8', 'Oracle Eloqua is a cloud-based marketing automation tool that helps businesses create and manage targeted digital campaigns. It''s designed to help businesses attract, engage, and nurture leads through various stages of the customer journey, from awareness to consideration to decision-making.
         With Eloqua, businesses can create and automate personalized campaigns across multiple channels, including email, social media, and mobile. The platform allows you to track and analyze customer behavior and engagement, and use that information to optimize your campaigns and improve your ROI.
         Eloqua''s key features include lead scoring and nurturing, campaign management, email marketing, landing page creation, social media management, and analytics. It integrates with a wide range of other marketing tools and platforms, including CRM systems, web analytics tools, and content management systems.
         Overall, Oracle Eloqua is a powerful tool for businesses looking to streamline their marketing efforts and improve their customer engagement and conversion rates. While it may take some time to learn how to use all of its features, it can be a valuable investment for businesses looking to take their marketing to the next level'
WHERE NOT EXISTS (SELECT 1 FROM ToolDetailedInfo WHERE toolName = 'Oracle Eloqua');


/* insert Adobe Marketo in database if not exist*/
INSERT INTO ToolDetailedInfo (toolName, toolVideoUrl, toolDescription)
SELECT 'Adobe Marketo', 'https://www.youtube.com/embed/d626-SXyh8I', 'Adobe Marketo is a marketing automation software owned by Adobe, which provides companies with a suite of tools to help them manage their marketing campaigns more effectively.
         Marketo helps businesses to automate their marketing tasks and manage their digital campaigns across multiple channels such as email, social media, web, and mobile. It also provides features like lead management, marketing analytics, and personalized messaging, which allows companies to nurture their leads and engage their customers more effectively.
         Adobe acquired Marketo in 2018 to expand its offerings in the marketing automation space, and it is now part of the Adobe Experience Cloud suite of products.'
WHERE NOT EXISTS (SELECT 1 FROM ToolDetailedInfo WHERE toolName = 'Adobe Marketo');


/* insert Active campaign in database if not exist*/
INSERT INTO ToolDetailedInfo (toolName, toolVideoUrl, toolDescription)
SELECT 'ActiveCampaign', 'https://www.youtube.com/embed/Oel0R9LZ1ZI', 'ActiveCampaign is a cloud-based software platform that provides businesses with a suite of tools to help them automate their marketing, sales, and customer support processes. The platform allows companies to manage their email marketing campaigns, automate their sales processes, and provide personalized customer support to their clients.
         ActiveCampaign offers features such as email marketing, marketing automation, CRM, sales automation, and customer support automation, all in one platform. It also includes integrations with third-party tools and services, which makes it easy for businesses to connect with other tools they are already using.
         Overall, ActiveCampaign is an all-in-one platform designed to help businesses grow by automating their processes and providing personalized customer experiences.' 
WHERE NOT EXISTS (SELECT 1 FROM ToolDetailedInfo WHERE toolName = 'ActiveCampaign');

/* insert SendBue in database if not exist*/
INSERT INTO ToolDetailedInfo (toolName, toolVideoUrl, toolDescription)
SELECT 'SendInBlue','https://www.youtube.com/embed/298LWIsOuy8' , 'SendInBlue is a cloud-based digital marketing platform that provides a range of tools for businesses to manage their email marketing, SMS marketing, and other digital marketing campaigns. It offers a comprehensive suite of features, including email and SMS marketing, marketing automation, landing pages, CRM, and even chat functionality. With its user-friendly interface and affordable pricing, Sendinblue is a popular choice for small to medium-sized businesses looking to streamline their digital marketing efforts.
         The platform also offers advanced reporting and analytics, allowing businesses to track the performance of their campaigns and make data-driven decisions to improve their marketing strategy.'
WHERE NOT EXISTS (SELECT 1 FROM ToolDetailedInfo WHERE toolName = 'SendInBlue');

/* insert MailerLite in database if not exist*/
INSERT INTO ToolDetailedInfo (toolName, toolVideoUrl, toolDescription)
SELECT 'MailerLite','https://www.youtube.com/embed/SaUixK5jHsE', 'MailerLite is an email marketing software that enables businesses to design and send professional email campaigns to their subscribers. 
         It offers features like drag-and-drop email builder, automation workflows, A/B testing, landing pages, and pop-up forms.
         The platform allows users to segment email lists and send targeted campaigns to specific groups of subscribers, increasing engagement and conversion rates. 
         MailerLite is known for its affordability, ease of use, and personalization capabilities. It is a popular choice for small to medium-sized businesses looking to improve their email marketing efforts.' 
WHERE NOT EXISTS (SELECT 1 FROM ToolDetailedInfo WHERE toolName = 'MailerLite');


-- MAX_INT = 2147483647

INSERT INTO MarketingToolData (toolName, budget, contacts, dbQuality, emailsPerMonth, features, hasDragAndDrop, hasFreeTrial, implementationModel, levelOfSupport, score)
SELECT 'Oracle Eloqua', 6600, 2147483647, 'High complexity', 2147483647, null,  "Drag & drop", false, 'Inhouse', 'Advanced', null
WHERE NOT EXISTS (SELECT 1 FROM MarketingToolData WHERE toolName = 'Oracle Eloqua');

INSERT INTO MarketingToolData (toolName, budget, contacts, dbQuality, emailsPerMonth, features, hasDragAndDrop, hasFreeTrial, implementationModel, levelOfSupport, score)
SELECT 'Adobe Marketo', 4100, 2147483647, 'High complexity', 2147483647, null, "Limited drag & drop" , false, 'Inhouse', 'Advanced', null
WHERE NOT EXISTS (SELECT 1 FROM MarketingToolData WHERE toolName = 'Adobe Marketo');

INSERT INTO MarketingToolData (toolName, budget, contacts, dbQuality, emailsPerMonth, features, hasDragAndDrop, hasFreeTrial, implementationModel, levelOfSupport, score)
SELECT 'ActiveCampaign', 200, 50000, 'Low complexity', 2147483647, null, "Drag & drop", true, 'Outsourced', 'Standard', null
WHERE NOT EXISTS (SELECT 1 FROM MarketingToolData WHERE toolName = 'ActiveCampaign');

INSERT INTO MarketingToolData (toolName, budget, contacts, dbQuality, emailsPerMonth, features, hasDragAndDrop, hasFreeTrial, implementationModel, levelOfSupport, score)
SELECT 'MailerLite', 50, 2147483647, 'Low complexity', 2147483647, null, "Point & click", true, 'Outsourced', 'Standard', null
WHERE NOT EXISTS (SELECT 1 FROM MarketingToolData WHERE toolName = 'MailerLite');

INSERT INTO MarketingToolData (toolName, budget, contacts, dbQuality, emailsPerMonth, features, hasDragAndDrop, hasFreeTrial, implementationModel, levelOfSupport, score)
SELECT 'SendInBlue', 49, 2147483647, 'Low complexity', 20000, null, "Point & click", true, 'Outsourced', 'Basic', null
WHERE NOT EXISTS (SELECT 1 FROM MarketingToolData WHERE toolName = 'SendInBlue');


