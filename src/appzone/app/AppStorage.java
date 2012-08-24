package appzone.app;


import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.res.AssetManager;

public class AppStorage {
	public static HashMap<String,HashMap<String,Object>> apps
		= new HashMap<String,HashMap<String,Object>>();
	public static ArrayList<String> categories = new ArrayList<String>();
	public static void initAppStorageFromXML() {
		/*Category initialization*/
		categories.add("Fun");
		categories.add("Other");
		categories.add("Sports");
		categories.add("Games");
		categories.add("News");
		categories.add("Entertainment");
		categories.add("Health");
		categories.add("Information");
		categories.add("Business");
		/*End Categories section*/
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			AssetManager assetManager = Common.activity.getAssets();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(assetManager.open("apps.xml"));
			doc.getDocumentElement().normalize();
			
			Common.doc = doc;
			Element root = doc.getDocumentElement();
			NodeList appList = root.getElementsByTagName("app");
			Common.nodes = appList;
			for ( int i=0; i<appList.getLength(); i++ ) {
				Node appItem = appList.item(i);
				if ( appItem.getNodeType() == Node.ELEMENT_NODE ) {
					Element appElement = (Element) appItem;
					HashMap<String,Object> thisApp = new HashMap<String,Object>();
					thisApp.put("appname", getTagValue("appname",appElement));
					thisApp.put("description", getTagValue("description",appElement));
					thisApp.put("help", getTagValue("help",appElement));
					String appimg = getTagValue("appimg",appElement);
					int appImgId = Integer.parseInt(appimg.substring(2), 16);
					thisApp.put("appimg", appImgId);
					thisApp.put("fields", getTagValue("fields",appElement));
					thisApp.put("button_replacements", getTagValue("button_replacements",appElement));
					thisApp.put("subscription", getTagValue("subscription",appElement));
					thisApp.put("category", getTagValue("category",appElement));
					thisApp.put("link", getTagValue("link",appElement));
					
					apps.put(new Integer(i).toString(), thisApp);
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	  }
	/**
	 * Old app storage method, initializes all data within the code (hard-coded)
	 */
	public static void initAppStorage() {
		/*Category initialization*/
		categories.add("Fun");
		categories.add("Other");
		categories.add("Sports");
		categories.add("Games");
		categories.add("News");
		categories.add("Entertainment");
		categories.add("Health");
		categories.add("Information");
		categories.add("Business");
		/*End Categories section*/
		/*-------------------------FUN SECTION--------------------------------------------*/
		/* Yalu Chat */
		HashMap<String,Object> yaluchat = new HashMap<String,Object>();
		yaluchat.put("appname", "Yalu Chat");
		yaluchat.put("description", "Yalu is introducing a revolutionised " +
				"way of chatting with finding a partner for you and letting " +
				"you to chat with him/her instantly. " +
				"Cost : 30.0\n " +
				"by Arunoda Susiripala");
		yaluchat.put("help", "To register with Yalu press " +
				"the Register button. To start chat type in the text field and press the Send" +
				" Message button. " +
				"Need help? Press the Help button. \n ");
		yaluchat.put("appimg", R.drawable.yaluchat);
		yaluchat.put("fields", "REG YL,YL $msg,YL HELP");
		yaluchat.put("button_replacements", "Register,Send Message,Help");
		yaluchat.put("subscription", true);
		yaluchat.put("category", "Fun");
		yaluchat.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("1", yaluchat);
		/* End Yalu Chat */
		/* Twitter2Sms */
		HashMap<String,Object> twitter2sms = new HashMap<String,Object>();
		twitter2sms.put("appname", "Twitter2Sms");
		twitter2sms.put("description", "This application can help to stay in touch with your " +
				"favourite Twitter friends.\n" +
				"Cost : 30.0 \n" +
				"by Libor");
		twitter2sms.put("help", "To register, hit the Register button.\n" +
								" For help, press the Help button.");
		twitter2sms.put("appimg", R.drawable.twitter2sms);
		twitter2sms.put("fields", "REG T2S,T2S HELP");
		twitter2sms.put("button_replacements", "Register,Help");
		twitter2sms.put("subscription", true);
		twitter2sms.put("category", "Fun");
		twitter2sms.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("2", twitter2sms);
		/* End Twitter2Sms */
		/* Fun Facts */
		HashMap<String,Object> funfacts = new HashMap<String,Object>();
		funfacts.put("appname", "Fun Facts");
		funfacts.put("description", "This application sends fun facts everyday to its users. " +
				"Cost : 30.0\n" +
				" by Haneez");
		funfacts.put("help", "To register with this service press the Register button. " +
				"To deregister press the Unregister button.\n");
		funfacts.put("appimg", R.drawable.funfacts);
		funfacts.put("fields", "REG FACTS,UNREG FACTS");
		funfacts.put("button_replacements", "Register,Unregister");
		funfacts.put("subscription", true);
		funfacts.put("category", "Fun");
		funfacts.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("10", funfacts);
		/*End Fun Facts*/
		
		/* Best friend calculator */
		HashMap<String,Object> bestfriendcalculator = new HashMap<String,Object>();
		bestfriendcalculator.put("appname", "Best Firend Calculator");
		bestfriendcalculator.put("description", "This application calculates friendship " +
				"percentage between two friends.\n" +
				"Cost : 5.0\n" +
				" by Charitha");
		bestfriendcalculator.put("help", "To get the friendship percentage type the two " +
				"names in the text field seperating them by a space  " +
				"and press the send button.\n");
		bestfriendcalculator.put("appimg", R.drawable.bestfriendcalculator);
		bestfriendcalculator.put("fields", "BFC $names");
		bestfriendcalculator.put("button_replacements", "Send");
		bestfriendcalculator.put("subscription", false);
		bestfriendcalculator.put("category", "Fun");
		bestfriendcalculator.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("22", bestfriendcalculator);
		/*End Best friend calculator*/
		
		/* Birthday and Character */
		HashMap<String,Object> birthdayandcharacter = new HashMap<String,Object>();
		birthdayandcharacter.put("appname", "Birthday and Character");
		birthdayandcharacter.put("description", "Find out what your birthday tells about " +
				"your character and the gem-stone associated with your month of birth.\n " +
				"Cost : 5.0\n" +
				" by Mithra");
		birthdayandcharacter.put("help", "Type month of birth and date of birth seperated " +
				"by a space and press send.\n " );
		birthdayandcharacter.put("appimg", R.drawable.birthdayandcharacter);
		birthdayandcharacter.put("fields", "BD $dateofbirth");
		birthdayandcharacter.put("button_replacements", "Send");
		birthdayandcharacter.put("subscription", false);
		birthdayandcharacter.put("category", "Fun");
		birthdayandcharacter.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("23", birthdayandcharacter);
		/*End Birthday and Character*/
		
		/* Chat Rooms */
		HashMap<String,Object> chatrooms = new HashMap<String,Object>();
		chatrooms.put("appname", "Chat Rooms");
		chatrooms.put("description", "ChatRooms aims to provide a chat forum for Sri lankans" +
				" from every part of Sri Lanka to chat,share ideas and make new friendship through SMS.\n " +
				"Cost : 30.0\n" +
				" by Tharakaw");
		chatrooms.put("help", "To register press the register button.To chat type the chat " +
				"message in the text field and press send.For help press help button.\n " );
		chatrooms.put("appimg", R.drawable.chatrooms);
		chatrooms.put("fields", "REG CR,CR $msg,CR HELP");
		chatrooms.put("button_replacements", "Register,Send,Help");
		chatrooms.put("subscription", true);
		chatrooms.put("category", "Fun");
		chatrooms.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("24", chatrooms);
		/*End Chat Rooms*/
		
		/* Chooti Malligen Ahanna */
		HashMap<String,Object> chootimalligenahanna = new HashMap<String,Object>();
		chootimalligenahanna.put("appname", "Chooti Malligen Ahanna");
		chootimalligenahanna.put("description", "This is an SMS based Fun Application. " +
				"To use this Application, Users can compose SMS message with any kind of " +
				"problem in Sinhala or English.\n " +
				"Cost : 5.0\n" +
				" by Harshs");
		chootimalligenahanna.put("help", "To register press the register button.To chat " +
				"type the chat message in the text field and press send.For help press help button.\n " );
		chootimalligenahanna.put("appimg", R.drawable.chootimalligenahanna);
		chootimalligenahanna.put("fields", "MALLI $problem,MALLI HELP");
		chootimalligenahanna.put("button_replacements", "Send,Help");
		chootimalligenahanna.put("subscription", false);
		chootimalligenahanna.put("category", "Fun");
		chootimalligenahanna.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("25", chootimalligenahanna);
		/*End Chooti Malligen Ahanna*/
		
		/* Daily Jokes */
		HashMap<String,Object> dailyjokes = new HashMap<String,Object>();
		dailyjokes.put("appname", "Daily Jokes");
		dailyjokes.put("description", "Subscribe to Daily jokes and have your day filled " +
				"with laughter! Rs. 1 per SMS.\n " +
				"Cost : 5.0\n" +
				" by Etisalat");
		dailyjokes.put("help", "To register press the register button.To deregister press " +
				"deregister button.\n " );
		dailyjokes.put("appimg", R.drawable.dailyjokes);
		dailyjokes.put("fields", "REG JOKE,STOP JOKE");
		dailyjokes.put("button_replacements", "Register,Deregister");
		dailyjokes.put("subscription", true);
		dailyjokes.put("category", "Fun");
		dailyjokes.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("26", dailyjokes);
		/*End Daily Jokes*/
		
		/* Dawase Kella */
		HashMap<String,Object> dawasekella = new HashMap<String,Object>();
		dawasekella.put("appname", "Dawase Kella");
		dawasekella.put("description", "To know the name of your today's dream Girl Just press " +
				"the find button.\n " +
				"Cost : 5.0\n" +
				" by Shanukap");
		dawasekella.put("help", "Press the find button to find your dream girl.\n " );
		dawasekella.put("appimg", R.drawable.dawasekella);
		dawasekella.put("fields", "KELLA");
		dawasekella.put("button_replacements", "Find");
		dawasekella.put("subscription", false);
		dawasekella.put("category", "Fun");
		dawasekella.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("27", dawasekella);
		/*End Dawase Kella*/
		
		/* Fabulous Jokes */
		HashMap<String,Object> fabulousjokes = new HashMap<String,Object>();
		fabulousjokes.put("appname", "Fabulous Jokes");
		fabulousjokes.put("description", "This is a subscription service which provides a JOKE via a " +
				"SMS everyday in English.\n " +
				"Cost : 30.0\n" +
				" by S.Muthukuda");
		fabulousjokes.put("help", "Press Register button to register and Unregister button " +
				"to unregister.\n " );
		fabulousjokes.put("appimg", R.drawable.fabulousjokes);
		fabulousjokes.put("fields", "REG EJOKE,UNREG EJOKE");
		fabulousjokes.put("button_replacements", "Register,Unregister");
		fabulousjokes.put("subscription", true);
		fabulousjokes.put("category", "Fun");
		fabulousjokes.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("28", fabulousjokes);
		/*End Fabulous Jokes*/
		
		/* Free SMS */
		HashMap<String,Object> freesms = new HashMap<String,Object>();
		freesms.put("appname", "Free SMS");
		freesms.put("description", "This application sends you messages relevant to the following " +
				"categories: New Year, Awurudu, Love, Birthday, Valentine, Friend (or Friendship), " +
				"Vesak, Poson, Xmas and Fun. \n " +
				"Cost : 5.0\n" +
				" by Bathiya");
		freesms.put("help", "Type the category in the given field and press send button.\n " );
		freesms.put("appimg", R.drawable.freesms);
		freesms.put("fields", "FREE $category");
		freesms.put("button_replacements", "Send");
		freesms.put("subscription", true);
		freesms.put("category", "Fun");
		freesms.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("29", freesms);
		/*End Free SMS*/
		
		/* Fun */
		HashMap<String,Object> funquotes = new HashMap<String,Object>();
		funquotes.put("appname", "Fun Quotes");
		funquotes.put("description", "This application sends 'Short and Funny' quotes for each user request.\n " +
				"Cost : 5.0\n" +
				" by Channa");
		funquotes.put("help", "Press the Request button to get fun quotes.\n " );
		funquotes.put("appimg", R.drawable.fun);
		funquotes.put("fields", "FUN");
		funquotes.put("button_replacements", "Request");
		funquotes.put("subscription", false);
		funquotes.put("category", "Fun");
		funquotes.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("30", funquotes);
		/*End Fun*/
		
		/* Funky Molee */
		HashMap<String,Object> funkymolee = new HashMap<String,Object>();
		funkymolee.put("appname", "Funky Molee");
		funkymolee.put("description", "This is a funny application that you can use in order to " +
				"find your brain power.By using this you can simply find out how " +
				"intelligent you are?\n " +
				"Cost : 5.0\n" +
				" by Milindag");
		funkymolee.put("help", "Type your name in the given field and press send.\n " );
		funkymolee.put("appimg", R.drawable.funkymolee);
		funkymolee.put("fields", "FM $name");
		funkymolee.put("button_replacements", "Send");
		funkymolee.put("subscription", false);
		funkymolee.put("category", "Fun");
		funkymolee.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("31", funkymolee);
		/*End Funky Molee*/
		
		/* Group SMS */
		HashMap<String,Object> groupsms = new HashMap<String,Object>();
		groupsms.put("appname", "Group SMS");
		groupsms.put("description", "This is a SMS based group messaging application. Users can " +
				"Create groups, join groups and can send SMS's to the whole group .This is a " +
				"registration base application.\n " +
				"Cost : 30.0\n" +
				" by Tharaka");
		groupsms.put("help", "To register press Register button.\n "+
				              "To create group press create button.\n"+
				              "To join a group type the group name and press add.\n"+
				              "To send sms type group name and message and press send.\n"+
				              "To deregister press unregister button.\n"+
				              "For help press help button");
		groupsms.put("appimg", R.drawable.groupsms);
		groupsms.put("fields", "REG GSMS,GSMS CREATE,GSMS ADD,GSMS SMS2 $msg,UNREG GSMS,GSMS HELP");
		groupsms.put("button_replacements", "Register,Create,Add,Send,Unregister,Help");
		groupsms.put("subscription", true);
		groupsms.put("category", "Fun");
		groupsms.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("32", groupsms);
		/*End Group SMS*/
		
		/* How Many Babies */
		HashMap<String,Object> howmanybabies = new HashMap<String,Object>();
		howmanybabies.put("appname", "How Many Babies");
		howmanybabies.put("description", "This application predicts the number of babies you " +
				"and your partner will have in the future!! \n " +
				"Cost : 5.0\n" +
				" by Gayan");
		howmanybabies.put("help", "Type your name and your partner's name seperated by a space " +
				"and press send.\n " );
		howmanybabies.put("appimg", R.drawable.howmanybabies);
		howmanybabies.put("fields", "BABA $name");
		howmanybabies.put("button_replacements", "Send");
		howmanybabies.put("subscription", false);
		howmanybabies.put("category", "Fun");
		howmanybabies.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("33", howmanybabies);
		/*End How Many Babies*/
		
		/* Love Friend */
		HashMap<String,Object> lovefriend = new HashMap<String,Object>();
		lovefriend.put("appname", "Love Friend");
		lovefriend.put("description", "This is a cool tool that measures love between you and " +
				"your dream mate & measures friendship between you and your friend. try Now !!!  \n " +
				"Cost : 5.0\n" +
				" by Roshan");
		lovefriend.put("help", "Type your name your partner's or friend's name and love/friend " +
				"seperated by a spaces and press send.\n "+
				"Press Help for help.");
		lovefriend.put("appimg", R.drawable.lovefriend);
		lovefriend.put("fields", "LF $name,LF FIND");
		lovefriend.put("button_replacements", "Send,Help");
		lovefriend.put("subscription", false);
		lovefriend.put("category", "Fun");
		lovefriend.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("34", lovefriend);
		/*End Love Friend*/
		
		/* Luck of the Day */
		HashMap<String,Object> luckoftheday = new HashMap<String,Object>();
		luckoftheday.put("appname", "Luck of the Day");
		luckoftheday.put("description", "You can get your luck of the day as a percentage by " +
				"this app.\n " +
				"Cost : 5.0\n" +
				" by Thulasya");
		luckoftheday.put("help", "Press the send button");
		luckoftheday.put("appimg", R.drawable.luckoftheday);
		luckoftheday.put("fields", "LUCK");
		luckoftheday.put("button_replacements", "Send");
		luckoftheday.put("subscription", false);
		luckoftheday.put("category", "Fun");
		luckoftheday.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("35", luckoftheday);
		/*End Luck of the Day*/
		
		/* Lucky Number Calculator */
		HashMap<String,Object> luckynumbercalculator = new HashMap<String,Object>();
		luckynumbercalculator.put("appname", "Lucky Number Calculator");
		luckynumbercalculator.put("description", "This application gives you the lucky number " +
				"of your name and lucky number of your birthday.\n " +
				"Cost : 5.0\n" +
				" by Charitha");
		luckynumbercalculator.put("help", "Type your name, date of birth,month of birth and " +
				"year of birth seperated by spaces and press send");
		luckynumbercalculator.put("appimg", R.drawable.luckynumbercalculator);
		luckynumbercalculator.put("fields", "NC $details");
		luckynumbercalculator.put("button_replacements", "Send");
		luckynumbercalculator.put("subscription", false);
		luckynumbercalculator.put("category", "Fun");
		luckynumbercalculator.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("36", luckynumbercalculator);
		/*End Lucky Number Calculator*/
		
		/* LUCKY NUMBERS */
		HashMap<String,Object> luckynumbers = new HashMap<String,Object>();
		luckynumbers.put("appname", "Lucky Numbers");
		luckynumbers.put("description", "An application to calculate Life number, Destiny number, " +
				"Soul number, and Birth number from Date of Birth and Full Name.\n " +
				"Cost : 5.0\n" +
				" by Priyantha");
		luckynumbers.put("help", "Type your date of birth (Eg.1987-12-28) and fullname seperated " +
				"by spaces and press send");
		luckynumbers.put("appimg", R.drawable.luckynumbers);
		luckynumbers.put("fields", "MYLUCK $details");
		luckynumbers.put("button_replacements", "Send");
		luckynumbers.put("subscription", false);
		luckynumbers.put("category", "Fun");
		luckynumbers.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("37", luckynumbers);
		/*End LUCKY NUMBERS*/
		
		/* Malsara */
		HashMap<String,Object> malsara = new HashMap<String,Object>();
		malsara.put("appname", "Malsara");
		malsara.put("description", "Users can either receive love quotes from this " +
				"application in both Sinhala and English Languages or send a love quote " +
				"to the application so that it will be shared with the other users of this " +
				"application. \n " +
				"Cost : 5.0\n" +
				" by Anuja");
		malsara.put("help", "To get quote press Get, to add quote type your quote " +
				"in the given field and press Add button");
		malsara.put("appimg", R.drawable.malsara);
		malsara.put("fields", "MS QOT,MS ADD $quote");
		malsara.put("button_replacements", "Get,Add");
		malsara.put("subscription", false);
		malsara.put("category", "Fun");
		malsara.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("38", malsara);
		/*End Malsara*/
		
		/* Manamalakama */
		HashMap<String,Object> manamalakama = new HashMap<String,Object>();
		manamalakama.put("appname", "Manamalakama");
		manamalakama.put("description", "Get your daily �Manamalakama� percentage with " +
				"this fun application. \n " +
				"Cost : 5.0\n" +
				" by Mithra");
		manamalakama.put("help", "To get quote 'Manamalakama' percentage press Request button");
		manamalakama.put("appimg", R.drawable.manamalakama);
		manamalakama.put("fields", "MANA");
		manamalakama.put("button_replacements", "Request");
		manamalakama.put("subscription", false);
		manamalakama.put("category", "Fun");
		manamalakama.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("39", manamalakama);
		/*End Manamalakama*/
		
		/* Name of your future partner */
		HashMap<String,Object> nameofyourfuturepartner = new HashMap<String,Object>();
		nameofyourfuturepartner.put("appname", "Name of your future partner");
		nameofyourfuturepartner.put("description", "Do you want to know the name of " +
				"your future partner?\n " +
				"Cost : 5.0\n" +
				" by Madura");
		nameofyourfuturepartner.put("help", "Type BOY/GIRL and your birth day seperated " +
				"by space and press send button");
		nameofyourfuturepartner.put("appimg", R.drawable.nameofyourfuturepartner);
		nameofyourfuturepartner.put("fields", "PART $details");
		nameofyourfuturepartner.put("button_replacements", "Send");
		nameofyourfuturepartner.put("subscription", false);
		nameofyourfuturepartner.put("category", "Fun");
		nameofyourfuturepartner.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("40", nameofyourfuturepartner);
		/*End Name of your future partner*/
		
		/* Sastare */
		HashMap<String,Object> sastare = new HashMap<String,Object>();
		sastare.put("appname", "Sastare");
		sastare.put("description", "This application gives you the satstare for the day. \n " +
				"Cost : 5.0\n" +
				" by Mithra");
		sastare.put("help", "To know the Dawase Sastare press Request button");
		sastare.put("appimg", R.drawable.sastare);
		sastare.put("fields", "SAS");
		sastare.put("button_replacements", "Request");
		sastare.put("subscription", false);
		sastare.put("category", "Fun");
		sastare.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("41", sastare);
		/*End Sastare*/
		
		/* Saththara */
		HashMap<String,Object> saththara = new HashMap<String,Object>();
		saththara.put("appname", "Saththara");
		saththara.put("description", "This is the mobile version of well known " +
				"Saththara Gurunnanse of Facebook.Through this app users can ask " +
				"saththara from Saththara Gurunnanse and get funny predictions from him. \n " +
				"Cost : 5.0\n" +
				" by Sachiths");
		saththara.put("help", "You can ask Saththara by entering your name in the " +
				"given field and pressing the send button.");
		saththara.put("appimg", R.drawable.saththara);
		saththara.put("fields", "SAT $name");
		saththara.put("button_replacements", "Send");
		saththara.put("subscription", false);
		saththara.put("category", "Fun");
		saththara.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("42", saththara);
		/*End Saththara*/
		
		/* Sinhalen Jokes */
		HashMap<String,Object> sinhalenjokes = new HashMap<String,Object>();
		sinhalenjokes.put("appname", "Sinhalen Jokes");
		sinhalenjokes.put("description", "This is a subscription service which provides " +
				"a JOKE via a SMS everyday in Sinhala. \n " +
				"Cost : 30.0\n" +
				" by S.Mutukuda");
		sinhalenjokes.put("help", "To register press Register button, to unregister " +
				"Press Unregister button");
		sinhalenjokes.put("appimg", R.drawable.sinhalajokes);
		sinhalenjokes.put("fields", "REG JOKE,UNREG JOKE");
		sinhalenjokes.put("button_replacements", "Register,Unregister");
		sinhalenjokes.put("subscription", true);
		sinhalenjokes.put("category", "Fun");
		sinhalenjokes.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("43", sinhalenjokes);
		/*End Sinhalen Jokes*/
		
		/* SMS Mania */
		HashMap<String,Object> smsmania = new HashMap<String,Object>();
		smsmania.put("appname", "SMS Mania");
		smsmania.put("description", "SMS Mania is a SMS pool. Its growing day by day. " +
				"You can request the message category that you want to receive. \n " +
				"Available SMS categories are FUN(Fun messages), BDAY(Birth day messages), " +
				"COOL (Cool messages), LOVE(Love messages), GM(Good morning messages), " +
				"GN(Good night messages), FRND(Messages for Friends)."+
				"Cost : 5.0\n" +
				" by Kumudu");
		smsmania.put("help", "Type the category name and press the send button");
		smsmania.put("appimg", R.drawable.smsmania);
		smsmania.put("fields", "SMS $category");
		smsmania.put("button_replacements", "Send");
		smsmania.put("subscription", false);
		smsmania.put("category", "Fun");
		smsmania.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("44", smsmania);
		/*End SMS Mania*/
		
		/* SMS Paradise */
		HashMap<String,Object> smsparadise = new HashMap<String,Object>();
		smsparadise.put("appname", "SMS Paradise ");
		smsparadise.put("description", "This application sends you the best messages " +
				"which you can send to your loved ones. In SMS Paradise you get many SMS " +
				"categories such as love quotes, fun quotes, new year wishes,friendship " +
				"quotes and birthday wishes. You can request for any category by sending a SMS.\n"+
				"Cost : 5.0\n" +
				" by Mahesh");
		smsparadise.put("help", "For love quotes press Love button.\n"+
				             "For fun quotes press Fun button.\n"+
				             "For new year wishes quotes press New year button.\n"+
				             "For friendship quotes press Friendship button.\n"+
				             "For birthday wishes quotes press Birthday button.");
		smsparadise.put("appimg", R.drawable.smsparadise);
		smsparadise.put("fields", "MP LV,MP FUN,MP NY,MP FR,MP BD");
		smsparadise.put("button_replacements", "Love,Fun,NewYear,Friendship,Birthday");
		smsparadise.put("subscription", false);
		smsparadise.put("category", "Fun");
		smsparadise.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("45", smsparadise);
		/*End SMS Paradise */
		
		/* Teen Alerts */
		HashMap<String,Object> teenalerts = new HashMap<String,Object>();
		teenalerts.put("appname", "Teen Alerts");
		teenalerts.put("description", "This provides Fun talks, Coolest gadgets, Hit songs download, " +
				"Creditcard offers, Hollywood/Bollywood Gossips, sports tournaments, New cinema, " +
				"Love SMS and lot more. \n " +
				"Cost : 30.0\n" +
				" by Sunari");
		teenalerts.put("help", "To register press Register button, to unregister " +
				"Press Unregister button and press Help button for help");
		teenalerts.put("appimg", R.drawable.teenalerts);
		teenalerts.put("fields", "REG TEEN,UNREG TEEN,TENN HELP");
		teenalerts.put("button_replacements", "Register,Unregister,Help");
		teenalerts.put("subscription", true);
		teenalerts.put("category", "Fun");
		teenalerts.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("46", teenalerts);
		/*End Teen Alerts*/
		
		/* Tongue Twisters */
		HashMap<String,Object> tonguetwisters = new HashMap<String,Object>();
		tonguetwisters.put("appname", "Tongue Twisters");
		tonguetwisters.put("description", "This application contains a wide collection of " +
				"tongue twisters which the user can get. \n " +
				"Cost : 5.0\n" +
				" by Upaniw");
		tonguetwisters.put("help", "Press Request button to get Tongue Twisters and " +
				"Help button for help ");
		tonguetwisters.put("appimg", R.drawable.tonguetwisters);
		tonguetwisters.put("fields", "TT,TT HELP");
		tonguetwisters.put("button_replacements", "Request,Help");
		tonguetwisters.put("subscription", false);
		tonguetwisters.put("category", "Fun");
		tonguetwisters.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("47", tonguetwisters);
		/*End Tongue Twisters*/
		
		/* Valentina */
		HashMap<String,Object> valentina = new HashMap<String,Object>();
		valentina.put("appname", "Valentina");
		valentina.put("description", "Do you want him/her to be your valentine? " +
				"but too nervous to ask? Get help from Valentina and clear all your doubts " +
				"this Valentines! \n " +
				"Cost : 5.0\n" +
				" by madreekn");
		valentina.put("help", "Press Request button to get help from Valentina ");
		valentina.put("appimg", R.drawable.valentina);
		valentina.put("fields", "VALEN");
		valentina.put("button_replacements", "Request");
		valentina.put("subscription", false);
		valentina.put("category", "Fun");
		valentina.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("48", valentina);
		/*End Valentina*/
		
		/* What Birthday tells about you */
		HashMap<String,Object> whatbirthdaytellsaboutyou = new HashMap<String,Object>();
		whatbirthdaytellsaboutyou.put("appname", "What Birthday tells about you");
		whatbirthdaytellsaboutyou.put("description", "Send your birthday and know what your birthday tells about you.\n " +
				"Cost : 5.0\n" +
				" by Thulasya");
		whatbirthdaytellsaboutyou.put("help", "Type your birthday as YYYY MM DD and press send button ");
		whatbirthdaytellsaboutyou.put("appimg", R.drawable.whatbirthdaytellsaboutyou);
		whatbirthdaytellsaboutyou.put("fields", "WBD $dob");
		whatbirthdaytellsaboutyou.put("button_replacements", "Send");
		whatbirthdaytellsaboutyou.put("subscription", false);
		whatbirthdaytellsaboutyou.put("category", "Fun");
		whatbirthdaytellsaboutyou.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("49", whatbirthdaytellsaboutyou);
		/*End What Birthday tells about you*/
		
		/*------------------------------------END FUN SECTION---------------------------*/
		
		/*------------------------------------OTHER SECTION----------------------------*/
		
		/* Love Calculator */
		HashMap<String,Object> lovecalculator = new HashMap<String,Object>();
		lovecalculator.put("appname", "Love Calculator");
		lovecalculator.put("description", "Match your real love.Will send a reply with the matching " +
				"percentage, " +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		lovecalculator.put("help", "To use this app type the two names in the text field seperating them by " +
				"a space and press the Send button\n");
		lovecalculator.put("appimg", R.drawable.lovecalculator);
		lovecalculator.put("fields", "LC $names");
		lovecalculator.put("button_replacements", "Send");
		lovecalculator.put("subscription", false);
		lovecalculator.put("category", "Other");
		lovecalculator.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("9", lovecalculator);
		/*End Love Calculator*/
		/* Porondam */
		HashMap<String,Object> porondam = new HashMap<String,Object>();
		porondam.put("appname", "Porondam");
		porondam.put("description", "Match horoscope according to traditional Visi Porondam." +
				"We send the number of good, medium and bad porondam." +
				"Cost : 5.0\n " +
				"by Chandana");
		porondam.put("help","Type girls birth information first and boys birth information second," +
				"which including birthday birth time and location, and press the Send button.\n");
		porondam.put("appimg", R.drawable.porondam);
		porondam.put("fields", "PO $details");
		porondam.put("button_replacements", "Send");
		porondam.put("subscription", false);
		porondam.put("category", "Other");
		porondam.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("12", porondam);
		/*End Porondam*/
		/* Bhasha English2Sinhala */
		HashMap<String,Object> bhashaenglish2sinhala = new HashMap<String,Object>();
		bhashaenglish2sinhala.put("appname", "Bhasha English2Sinhala");
		bhashaenglish2sinhala.put("description", "Bhasha English2Sinhala is a SMS based English to " +
				"Sinhala Dictionary.You can simply send any English word(s) to this dictionary & " +
				"receive Sinhala translation(s) as a reply.\n" +
				"Cost : 5.0\n" +
				"by Bhasha");
		bhashaenglish2sinhala.put("help","To use, type any English word in the text area and " +
				"press the Send Word button.\n");
		bhashaenglish2sinhala.put("appimg", R.drawable.bhashaenglish2sinhala);
		bhashaenglish2sinhala.put("fields", "ES $word");
		bhashaenglish2sinhala.put("button_replacements", "Send Word");
		bhashaenglish2sinhala.put("subscription", false);
		bhashaenglish2sinhala.put("category", "Other");
		bhashaenglish2sinhala.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("21", bhashaenglish2sinhala);
		/*End Bhasha English2Sinhala*/
		/* Lyrics2Sms */
		HashMap<String,Object> lyrics2sms = new HashMap<String,Object>();
		lyrics2sms.put("appname", "Lyrics2Sms");
		lyrics2sms.put("description", "This application can help you to get info about artists, " +
				"their albums and songs including lyrics.\n" +
				"Cost : 30.0\n" +
				"by Libor");
		lyrics2sms.put("help","Press Register to register. Press Help for help.\n");
		lyrics2sms.put("appimg", R.drawable.lyrics2sms);
		lyrics2sms.put("fields", "REG L2S,L2S HELP");
		lyrics2sms.put("button_replacements", "Register,Help");
		lyrics2sms.put("subscription", true);
		lyrics2sms.put("category", "Other");
		lyrics2sms.put("link", "http://apps.appzone.lk/#app_250");
		
		apps.put("111", lyrics2sms);
		/*End Lyrics2Sms*/
		/* Dhamma */
		HashMap<String,Object> dhamma = new HashMap<String,Object>();
		dhamma.put("appname", "Dhamma");
		dhamma.put("description", "Application to receive a daily verse from The Dhammapada as per " +
				"the translation of Acharya Buddharakkitha. All proceeds received by the developer " +
				"for this application will be given out for charity.\n" +
				"Cost : 30.0\n" +
				"by priyantha");
		dhamma.put("help","Press Register to register. Press Unregister to unregister.\n");
		dhamma.put("appimg", R.drawable.dhamma);
		dhamma.put("fields", "REG DHAMMA,UNREG DHAMMA");
		dhamma.put("button_replacements", "Register,Unregister");
		dhamma.put("subscription", true);
		dhamma.put("category", "Other");
		dhamma.put("link", "http://apps.appzone.lk/#app_211");
		
		apps.put("112", dhamma);
		/*End Dhamma*/
		/* Mithra */
		HashMap<String,Object> mithra = new HashMap<String,Object>();
		mithra.put("appname", "Mithra");
		mithra.put("description", "In MITHRA app user can chat with single friend and group.\n" +
				"Cost : 30.0\n" +
				"by mithra");
		mithra.put("help","Press Register to register. Press Help for help.\n");
		mithra.put("appimg", R.drawable.mithra);
		mithra.put("fields", "REG MI,MI HELP");
		mithra.put("button_replacements", "Register,Help");
		mithra.put("subscription", true);
		mithra.put("category", "Other");
		mithra.put("link", "http://apps.appzone.lk/#app_241");
		
		apps.put("113", mithra);
		/*End Mithra*/
		/* Bible Verse for the day */
		HashMap<String,Object> bibleverse = new HashMap<String,Object>();
		bibleverse.put("appname", "Bible Verse for the day");
		bibleverse.put("description", "Verse for the day is an application which sends meaningful " +
				"and inspirational Bible verse to all who have registered. \n" +
				"Cost : 30.0\n" +
				"by Jason Jebanesan");
		bibleverse.put("help","Press Register to register. Press Unregister to unregister.\n");
		bibleverse.put("appimg", R.drawable.bibleverse);
		bibleverse.put("fields", "REG VERSE,UNREG VERSE");
		bibleverse.put("button_replacements", "Register,Unregister");
		bibleverse.put("subscription", true);
		bibleverse.put("category", "Other");
		bibleverse.put("link", "http://apps.appzone.lk/#app_167");
		
		apps.put("114", bibleverse);
		/*End Bible Verse for the day*/
		/* Sai Baba Sayings */
		HashMap<String,Object> saibabasayings = new HashMap<String,Object>();
		saibabasayings.put("appname", "Sai Baba Sayings");
		saibabasayings.put("description", "Application to receive a daily verse from Bhagavan Sri " +
				"Sathya Sai Baba.\n" +
				"Cost : 30.0\n" +
				"by priyantha");
		saibabasayings.put("help","Press Register to register. Press Unregister to unregister.\n");
		saibabasayings.put("appimg", R.drawable.saibabasayings);
		saibabasayings.put("fields", "REG SAI,UNREG SAI");
		saibabasayings.put("button_replacements", "Register,Unregister");
		saibabasayings.put("subscription", true);
		saibabasayings.put("category", "Other");
		saibabasayings.put("link", "http://apps.appzone.lk/#app_245");
		
		apps.put("115", saibabasayings);
		/*End Sai Baba Sayings*/
		/* Daily Islam */
		HashMap<String,Object> dailyislam = new HashMap<String,Object>();
		dailyislam.put("appname", "Daily Islam");
		dailyislam.put("description", "Saheeh Hadees.Quotes from the Quran.Islamic Thoughts." +
				"Occasional Duas. Reminder for important days in Islam.\n" +
				"Cost : 30.0\n" +
				"by Ijas Ahmed");
		dailyislam.put("help","Press Register to register. Press Unregister to unregister." +
				"Press Help for help.\n");
		dailyislam.put("appimg", R.drawable.dailyislam);
		dailyislam.put("fields", "REG ISLAM,UNREG ISLAM,ISLAM HELP");
		dailyislam.put("button_replacements", "Register,Unregister,Help");
		dailyislam.put("subscription", true);
		dailyislam.put("category", "Other");
		dailyislam.put("link", "http://apps.appzone.lk/#app_283");
		
		apps.put("116", dailyislam);
		/*End Daily Islam*/
		/* Dog Names */
		HashMap<String,Object> dognames = new HashMap<String,Object>();
		dognames.put("appname", "Dog Names");
		dognames.put("description", "This simple app gives you access to hundreds of unusual names to " +
				"suit your male/female puppies. You can also view a description given to each name!\n" +
				"Cost : 5.0\n" +
				"by gimasha");
		dognames.put("help","Press Male to get male names, Female to get female names." +
				"Press More Male or More Female to get more names. Type a particular name" +
				"and press the Description button to get a description on that name.\n");
		dognames.put("appimg", R.drawable.dognames);
		dognames.put("fields", "DOG M,DOG F,DOG M MORE,DOG F MORE,DOG TAG $name");
		dognames.put("button_replacements", "Male,Female,More Male,More Female,Description");
		dognames.put("subscription", false);
		dognames.put("category", "Other");
		dognames.put("link", "http://apps.appzone.lk/#app_231");
		
		apps.put("117", dognames);
		/*End Dog Names*/
		/* Greeting */
		HashMap<String,Object> greeting = new HashMap<String,Object>();
		greeting.put("appname", "Greeting");
		greeting.put("description", "This application gives you greeting messages such as Love, Friendship, " +
				"Good morning, Good night and wishes for special occasions such as New year, X’ mas," +
				"and Birthdays. \n" +
				"Cost 5.0\n" +
				"by mithra");
		greeting.put("help","Press the relevant button to get greetings related to it.\n");
		greeting.put("appimg", R.drawable.greeting);
		greeting.put("fields", "GR LV,GR FS,GR GN,GR GM,GR CH,GR NY,GR BD");
		greeting.put("button_replacements", "Love,Friendship,Goodnight,Good Morning,Christmas,New Year,Birthday");
		greeting.put("subscription", false);
		greeting.put("category", "Other");
		greeting.put("link", "http://apps.appzone.lk/#app_114");
		
		apps.put("118", greeting);
		/*End Greeting*/
		/* Sms2Email */
		HashMap<String,Object> sms2email = new HashMap<String,Object>();
		sms2email.put("appname", "Sms2Email");
		sms2email.put("description", "Send quick email message using SMS messages\n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		sms2email.put("help","To send an email type <Email Address><space><message> and press Send.\n");
		sms2email.put("appimg", R.drawable.sms2email);
		sms2email.put("fields", "S2E $details");
		sms2email.put("button_replacements", "Send");
		sms2email.put("subscription", false);
		sms2email.put("category", "Other");
		sms2email.put("link", "http://apps.appzone.lk/#app_29");
		
		apps.put("119", sms2email);
		/*End Sms2Email*/
		/* Daily Horoscope */
		HashMap<String,Object> dailyhoroscope = new HashMap<String,Object>();
		dailyhoroscope.put("appname", "Daily Horoscope");
		dailyhoroscope.put("description", "This application gives your true horoscope for your zodiac sign " +
				"from one of the famous astrologist in Sri Lanka every day morning. \n" +
				"Cost : 30.0\n" +
				"by Navin");
		dailyhoroscope.put("help","Press Register to register, Unregister to unregister.\n");
		dailyhoroscope.put("appimg", R.drawable.dailyhoroscope);
		dailyhoroscope.put("fields", "REG ASTRO,UNREG ASTRO");
		dailyhoroscope.put("button_replacements", "Register,Unregister");
		dailyhoroscope.put("subscription", true);
		dailyhoroscope.put("category", "Other");
		dailyhoroscope.put("link", "http://apps.appzone.lk/#app_163");
		
		apps.put("120", dailyhoroscope);
		/*End Daily Horoscope*/
		/* Express Your Heart */
		HashMap<String,Object> expressyourheart = new HashMap<String,Object>();
		expressyourheart.put("appname", "Express Your Heart ");
		expressyourheart.put("description", "Want to wish & impress your friends in DIFFERENT LANGUAGES.\n" +
				"Cost : 5.0\n" +
				"by Manoj Weerasekara");
		expressyourheart.put("help","Press the button corresponding to your request. Press Help for help.\n");
		expressyourheart.put("appimg", R.drawable.expressyourheart);
		expressyourheart.put("fields", "HE ILU,HE GM,HE GN,HE HB,HE GL,HE MC,HE HELP");
		expressyourheart.put("button_replacements", "Love,Morning,Night,Birthday,Luck,Christmas,Help");
		expressyourheart.put("subscription", false);
		expressyourheart.put("category", "Other");
		expressyourheart.put("link", "http://apps.appzone.lk/#app_296");
		
		apps.put("121", expressyourheart);
		/*End Express Your Heart */
		/* Wish */
		HashMap<String,Object> wish = new HashMap<String,Object>();
		wish.put("appname", "Wish ");
		wish.put("description", "This application sends the user with greetings for requested occasions. " +
				"The messages are sent based on the request language i.e. Sinhala, English.\n" +
				"Cost : 5.0\n" +
				"by kalpap");
		wish.put("help","Press the button corresponding to your request and language. Press Help for help.\n");
		wish.put("appimg", R.drawable.wish);
		wish.put("fields", "WI BD SI,WI BD EN,WI NY SI,WI NY EN");
		wish.put("button_replacements", "Birthday(Sinhala),Birthday(English),New Year(Sinhala),New Year(English)");
		wish.put("subscription", false);
		wish.put("category", "Other");
		wish.put("link", "http://apps.appzone.lk/#app_183");
		
		apps.put("122", wish);
		/* End Wish */
		/* Horoscope */
		HashMap<String,Object> horoscope = new HashMap<String,Object>();
		horoscope.put("appname", "Horoscope ");
		horoscope.put("description", "This application gives the astrology readings of the year for all " +
				"zodiac signs.\n" +
				"Cost : 5.0\n" +
				"by dushantha");
		horoscope.put("help","Type your zodiac sign and press the 'Get Reading' button. Zodiac signs can be defined as follows: " +
				"Aries (Mesha), Taurus (Vusabha), Gemini (Mituna), Cancer (Kataka), Leo (Sinha), Virgo (Kanya), " +
				"Libra (Tula), Scorpio (Vushvika), Sagittarius (Danu), Capricorn (Makara), Aquarius (Kumbha) " +
				"or Pisces (Mina).\n");
		horoscope.put("appimg", R.drawable.horoscope);
		horoscope.put("fields", "HOROSCOPE $sign");
		horoscope.put("button_replacements", "Get Reading");
		horoscope.put("subscription", false);
		horoscope.put("category", "Other");
		horoscope.put("link", "http://apps.appzone.lk/#app_173");
		
		apps.put("123", horoscope);
		/* End Horoscope */
		/* SMS-DER */
		HashMap<String,Object> smsder = new HashMap<String,Object>();
		smsder.put("appname", "SMS-DER");
		smsder.put("description", "This application gives the currency name of the country given by the user " +
				"and the relevant exchange rate.\n" +
				"Cost : 5.0\n" +
				"by Charitha");
		smsder.put("help","To get the exchange rate and currency name of a country type in the country name and " +
				"press the Get Currency button.\n");
		smsder.put("appimg", R.drawable.smsder);
		smsder.put("fields", "DER $country");
		smsder.put("button_replacements", "Get Currency");
		smsder.put("subscription", false);
		smsder.put("category", "Other");
		smsder.put("link", "http://apps.appzone.lk/#app_116");
		
		apps.put("124", smsder);
		/* End SMS-DER */
		/* Lagna Aya Waya */
		HashMap<String,Object> lagnaayawaya = new HashMap<String,Object>();
		lagnaayawaya.put("appname", "Lagna Aya Waya");
		lagnaayawaya.put("description", "Get the 'Aya Vaya' of year for your 'Lagnaya' according to astrology. \n" +
				"Cost : 5.0\n" +
				"by Anuja");
		lagnaayawaya.put("help","Type in your star sign and press 'Get Aya Waya'. The star signs are as follows: " +
				"Mesha, Vurshaba, Mithuna, Kataka, Sinha, Kanya, Thula, Vurshchika, Danu, Makara, Kumba, Meena. \n");
		lagnaayawaya.put("appimg", R.drawable.lagnaayawaya);
		lagnaayawaya.put("fields", "AV $sign");
		lagnaayawaya.put("button_replacements", "Get Aya Waya");
		lagnaayawaya.put("subscription", false);
		lagnaayawaya.put("category", "Other");
		lagnaayawaya.put("link", "http://apps.appzone.lk/#app_120");
		
		apps.put("125", lagnaayawaya);
		/* End Lagna Aya Waya */
		/* SMS Forum */
		HashMap<String,Object> smsforum = new HashMap<String,Object>();
		smsforum.put("appname", "SMS Forum");
		smsforum.put("description", "This application is basically a forum which users can subscribe and register." +
				" Then users can post questions, answer questions, search for a term and view any past " +
				"forum posts via sms.\n" +
				"Cost : 30.0\n" +
				"by Amila Ranathunga");
		smsforum.put("help","Press Register to register and Unregister to Unregister. Press Help to get help.\n");
		smsforum.put("appimg", R.drawable.smsforum);
		smsforum.put("fields", "REG FRM,UNREG FRM,FRM HELP");
		smsforum.put("button_replacements", "Register,Unregister,Help");
		smsforum.put("subscription", true);
		smsforum.put("category", "Other");
		smsforum.put("link", "http://apps.appzone.lk/#app_280");
		
		apps.put("126", smsforum);
		/* End SMS Forum */
		/* Greetings */
		HashMap<String,Object> greetings = new HashMap<String,Object>();
		greetings.put("appname", "Greetings");
		greetings.put("description", "In the coming Christmas season, tell your parents, friends& loved " +
				"ones how much you care with Greetings. You can request touching and exciting Christmas greetings. " +
				"(The greetings are currently available in English language.)\n" +
				"Cost : 5.0\n" +
				"by Dinitha");
		greetings.put("help","Press the Get Greetings button to receive Christmas greeting messages.\n");
		greetings.put("appimg", R.drawable.greetings);
		greetings.put("fields", "GREETINGS");
		greetings.put("button_replacements", "Get Greetings");
		greetings.put("subscription", false);
		greetings.put("category", "Other");
		greetings.put("link", "http://apps.appzone.lk/#app_117");
		
		apps.put("127", greetings);
		/* End Greetings */
		/* English-Sinhala Dictionary */
		HashMap<String,Object> englishsinhaladic = new HashMap<String,Object>();
		englishsinhaladic.put("appname", "English-Sinhala Dictionary");
		englishsinhaladic.put("description", "This application provides you with definitions for more than 50,000 " +
				"English words. You can find the exact Sinhala meaning of any English word easily. " +
				"Cost : 5.0\n" +
				"by Tharaka");
		englishsinhaladic.put("help","Type the English word and press Send Word to get the Sinhala meaning.\n");
		englishsinhaladic.put("appimg", R.drawable.englishsinhaladic);
		englishsinhaladic.put("fields", "DIC $word");
		englishsinhaladic.put("button_replacements", "Send Word");
		englishsinhaladic.put("subscription", false);
		englishsinhaladic.put("category", "Other");
		englishsinhaladic.put("link", "http://apps.appzone.lk/#app_166");
		
		apps.put("128", englishsinhaladic);
		/* End English-Sinhala Dictionary */
		/* Free Mobile Themes */
		HashMap<String,Object> freemobilethemes = new HashMap<String,Object>();
		freemobilethemes.put("appname", "Free Mobile Themes");
		freemobilethemes.put("description", "FREE Download Mobile Themes.In this application user can get " +
				"new mobile themes for their mobiles.\n" +
				"Cost : 5.0\n" +
				"by mithra");
		freemobilethemes.put("help","Press the relevant category to get themes. " +
				"Phone Category Nokia s60v5, Nokia N-Series, Nokia Series 60.\n");
		freemobilethemes.put("appimg", R.drawable.freemobilethemes);
		freemobilethemes.put("fields", "TH N,TH NN,TH NOKIA");
		freemobilethemes.put("button_replacements", "Nokia s60v5,Nokia N-Series,Nokia Series 60");
		freemobilethemes.put("subscription", false);
		freemobilethemes.put("category", "Other");
		freemobilethemes.put("link", "http://apps.appzone.lk/#app_128");
		
		apps.put("129", freemobilethemes);
		/* End Free Mobile Themes */
		/* Sadaham Sithuvili */
		HashMap<String,Object> sadahamsithuvili = new HashMap<String,Object>();
		sadahamsithuvili.put("appname", "Sadaham Sithuvili");
		sadahamsithuvili.put("description", "Receive daily Dhamma Verses on your mobile.Try this service free " +
				"for first 15 days.Just Rs.1/= per day after that.\n" +
				"Cost : 30.0\n" +
				"by Roshan");
		sadahamsithuvili.put("help","Press Register to register and Help for help." +
				"Type your question and press Ask to ask a question.\n");
		sadahamsithuvili.put("appimg", R.drawable.sadahamsithuvili);
		sadahamsithuvili.put("fields", "REG DP,DP HELP,DP QUIZ $question");
		sadahamsithuvili.put("button_replacements", "Register,Help,Ask");
		sadahamsithuvili.put("subscription", true);
		sadahamsithuvili.put("category", "Other");
		sadahamsithuvili.put("link", "http://apps.appzone.lk/#app_288");
		
		apps.put("130", sadahamsithuvili);
		/* End Sadaham Sithuvili */
		/* Mobile Fonts */
		HashMap<String,Object> mobilefonts = new HashMap<String,Object>();
		mobilefonts.put("appname", "Mobile Fonts");
		mobilefonts.put("description", "FREE Download Mobile Fonts.User can get new mobile fonts by this " +
				"application.\n" +
				"Cost : 5.0\n" +
				"by mithra");
		mobilefonts.put("help","Press the Get Fonts button to get fonts.\n");
		mobilefonts.put("appimg", R.drawable.mobilefonts);
		mobilefonts.put("fields", "FONT");
		mobilefonts.put("button_replacements", "Get Fonts");
		mobilefonts.put("subscription", false);
		mobilefonts.put("category", "Other");
		mobilefonts.put("link", "http://apps.appzone.lk/#app_127");
		
		apps.put("131", mobilefonts);
		/* End Mobile Fonts */
		/* Mobile Software */
		HashMap<String,Object> mobilesoftware = new HashMap<String,Object>();
		mobilesoftware.put("appname", "Mobile Software");
		mobilesoftware.put("description", "Free Mobile Software application.Users can download mobile softwares " +
				"from this application.\n" +
				"Cost : 5.0\n" +
				"by mithra");
		mobilesoftware.put("help","Choose the relevant category of phone." +
				"Phone Category Nokia s60v5, Nokia N-Series, Nokia Series 60, iPhone\n");
		mobilesoftware.put("appimg", R.drawable.mobilesoftware);
		mobilesoftware.put("fields", "SOF N,SOF NN,SOF NOKIA,SOF I");
		mobilesoftware.put("button_replacements", "Nokia s60v5,Nokia N-Series,Nokia Series 60,iPhone");
		mobilesoftware.put("subscription", false);
		mobilesoftware.put("category", "Other");
		mobilesoftware.put("link", "http://apps.appzone.lk/#app_126");
		
		apps.put("132", mobilesoftware);
		/* End Mobile Software */
		/* Primary Horoscope */
		HashMap<String,Object> primaryhoroscope = new HashMap<String,Object>();
		primaryhoroscope.put("appname", "Primary Horoscope");
		primaryhoroscope.put("description", "Input your birthday and It will show your and your life partner " +
				"qualities according to the historical numerology methods.\n" +
				"Cost : 5.0\n" +
				"by T.Tharindu madushanka peiris");
		primaryhoroscope.put("help","Type your birthday and press Get Qualities to run the app." +
				"Press Help for help.\n");
		primaryhoroscope.put("appimg", R.drawable.primaryhoroscope);
		primaryhoroscope.put("fields", "LOVE123 $birthday,LOVE HELP");
		primaryhoroscope.put("button_replacements", "Get Qualities,Help");
		primaryhoroscope.put("subscription", false);
		primaryhoroscope.put("category", "Other");
		primaryhoroscope.put("link", "http://apps.appzone.lk/#app_297");
		
		apps.put("133", primaryhoroscope);
		/* End Primary Horoscope */
		/* Metric Converter */
		HashMap<String,Object> metricconverter = new HashMap<String,Object>();
		metricconverter.put("appname", "Metric Converter");
		metricconverter.put("description", "This application can be used to convert values in metric units to " +
				"imperial units and vice versa.\n" +
				"Cost : 5.0\n" +
				"by Roshan");
		metricconverter.put("help","kg2lb=kg to pounds,lb2kg=pounds to kg,cm2ft=cm to ft," +
				"ft2cm=feet to cm,l2gal=liters to gallons,gal2l=gallons to liters. Type the value and press" +
				"the relevant button for conversion. Press Help for help.\n");
		metricconverter.put("appimg", R.drawable.metricconverter);
		metricconverter.put("fields", "MC 1 $value,MC 2 $value,MC 3 $value,MC 4 $value,MC 5 $value,MC 6 $value,MC HELP");
		metricconverter.put("button_replacements", "kg2lb,lb2kg,cm2ft,ft2cm,l2gal,gal2l,Help");
		metricconverter.put("subscription", false);
		metricconverter.put("category", "Other");
		metricconverter.put("link", "http://apps.appzone.lk/#app_83");
		
		apps.put("134", metricconverter);
		/* End Metric Converter */
		/*---------------------------------END OTHER SECTION---------------------------*/
		
		/*---------------------------------SPORTS SECTION------------------------------*/
		/* School */
		HashMap<String,Object> school = new HashMap<String,Object>();
		school.put("appname", "School");
		school.put("description", "You can follow the updates of your school matches and your " +
				"favorite sports tournaments via SMS alerts. This application can give all types " +
				"of information.\n" +
				"Cost : 30.0\n" +
				"by CheerYourTeam.com");
		school.put("help","1. Particular school's sports updates To subscribe type the school name in the text" +
				"field and press the Register School button. To unsubscribe type the school name and press" +
				"the Unregister School button.\n" +
				"2.Sports updates of a particular sport regardless of schools: To subscribe " +
				"type the name of the sport and press the Register Sport button." +
				"To unsubscribe type the sport name and press Unregister Sport.\n" +
				"3. All sports updates of all the schools To subscribe press Register School. " +
				"To unsubscribe press Unregister School.\n");
		school.put("appimg", R.drawable.school);
		school.put("fields", "REG SCHOOL $school,REG SPORT $sport,UNREG SCHOOL $school,UNREG SPORT $sport");
		school.put("button_replacements", "Register School,Register Sport,Unregister School,Unregister Sport");
		school.put("subscription", true);
		school.put("category", "Sports");
		school.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("5", school);
		/*End School*/
		/* CrickAtMobile */
		HashMap<String,Object> crickatmobile = new HashMap<String,Object>();
		crickatmobile.put("appname", "CrickAtMobile");
		crickatmobile.put("description", "CrickAt Mobile for cricket lovers.\n " +
				"Cost : 30.0\n" +
				"by Shayanthan");
		crickatmobile.put("help","Press Register to register" +
				"and Unregister to unregister.\n");
		crickatmobile.put("appimg", R.drawable.crickatmobile);
		crickatmobile.put("fields", "REG CRICK,UNREG CRICK");
		crickatmobile.put("button_replacements", "Register,Unregister");
		crickatmobile.put("subscription", true);
		crickatmobile.put("category", "Sports");
		crickatmobile.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("17", crickatmobile);
		/*End CrickAtMobile*/
		/* Cricnews */
		HashMap<String,Object> cricnews = new HashMap<String,Object>();
		cricnews.put("appname", "Cricnews");
		cricnews.put("description", "cricnews is a subscription based application." +
				"You will recieve criket updates on your mobile." +
				"\"Keep In Touch with Gentlemen's Game\"\n" +
				"Cost : 30.0\n" +
				"by Roshan");
		cricnews.put("help","Press Register to register" +
				"and Unregister to unregister. Press Help for help.\n");
		cricnews.put("appimg", R.drawable.cricnews);
		cricnews.put("fields", "REG CRICNEWS,UNREG CRICNEWS,CRICNEWS HELP");
		cricnews.put("button_replacements", "Register,Unregister,Help");
		cricnews.put("subscription", true);
		cricnews.put("category", "Sports");
		cricnews.put("link", "http://apps.appzone.lk/#app_255");
		
		apps.put("103", cricnews);
		/*End Cricnews*/
		/* Cricket Live Scores */
		HashMap<String,Object> cricketlivescores = new HashMap<String,Object>();
		cricketlivescores.put("appname", "Cricket Live Scores");
		cricketlivescores.put("description", "Get the latest international cricket updates " +
				"with this application.\n" +
				"Cost : 5.0\n" +
				"by Charitha");
		cricketlivescores.put("help","Press the Get Update button to get the latest" +
				"cricket updates.\n");
		cricketlivescores.put("appimg", R.drawable.cricketlivescores);
		cricketlivescores.put("fields", "CRI");
		cricketlivescores.put("button_replacements", "Get Update");
		cricketlivescores.put("subscription", false);
		cricketlivescores.put("category", "Sports");
		cricketlivescores.put("link", "http://apps.appzone.lk/#app_134");
		
		apps.put("104", cricketlivescores);
		/*End Cricket Live Scores*/
		/* School & Club Rugby */
		HashMap<String,Object> schoolrugby = new HashMap<String,Object>();
		schoolrugby.put("appname", "School & Club Rugby");
		schoolrugby.put("description", "Subscribe to School & Club rugby alerts. " +
				"Rs.30 per month during the rugby season. \n" +
				"Cost : 30.0\n" +
				"by Etisalat");
		schoolrugby.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		schoolrugby.put("appimg", R.drawable.schoolrugby);
		schoolrugby.put("fields", "REG RUGBY,STOP RUGBY");
		schoolrugby.put("button_replacements", "Register,Unregister");
		schoolrugby.put("subscription", true);
		schoolrugby.put("category", "Sports");
		schoolrugby.put("link", "http://apps.appzone.lk/#app_42");
		
		apps.put("105", schoolrugby);
		/*End School & Club Rugby*/
		/* ESPN Rugby Alerts */
		HashMap<String,Object> espnrugbyalerts = new HashMap<String,Object>();
		espnrugbyalerts.put("appname", "ESPN Rugby Alerts");
		espnrugbyalerts.put("description", "Subscribe to daily alerts and updates " +
				"of the ESPN Rugby matches.\n" +
				"Cost : 30.0\n" +
				"by Etisalat");
		espnrugbyalerts.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		espnrugbyalerts.put("appimg", R.drawable.espnrugbyalerts);
		espnrugbyalerts.put("fields", "REG SCRUM,STOP SCRUM");
		espnrugbyalerts.put("button_replacements", "Register,Unregister");
		espnrugbyalerts.put("subscription", true);
		espnrugbyalerts.put("category", "Sports");
		espnrugbyalerts.put("link", "http://apps.appzone.lk/#app_43");
		
		apps.put("106", espnrugbyalerts);
		/*End ESPN Rugby Alerts*/
		/* SL Cricket */
		HashMap<String,Object> slcricket = new HashMap<String,Object>();
		slcricket.put("appname", "SLCricket");
		slcricket.put("description", "Receive cricket updates and alerts " +
				"for all matches played by Sri Lanka. Rs 5 per match.\n" +
				"Cost : 5.0\n" +
				"by Etisalat");
		slcricket.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		slcricket.put("appimg", R.drawable.etisalat);
		slcricket.put("fields", "CRICKSRI,STOP CRICKSRI");
		slcricket.put("button_replacements", "Register,Unregister");
		slcricket.put("subscription", true);
		slcricket.put("category", "Sports");
		slcricket.put("link", "http://apps.appzone.lk/#app_30");
		
		apps.put("107", slcricket);
		/*End SLCricket*/
		/* SL Cricket(Sinhala) */
		HashMap<String,Object> slcricketsinhala = new HashMap<String,Object>();
		slcricketsinhala.put("appname", "SLCricket");
		slcricketsinhala.put("description", "Recieve cricket updates and alerts in sinhala " +
				"language for all matches played by Sri Lanka. Rs 5 per match.\n" +
				"Cost : 5.0\n" +
				"by Etisalat");
		slcricketsinhala.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		slcricketsinhala.put("appimg", R.drawable.etisalat);
		slcricketsinhala.put("fields", "CRIKSIN,STOP CRIKSIN");
		slcricketsinhala.put("button_replacements", "Register,Unregister");
		slcricketsinhala.put("subscription", true);
		slcricketsinhala.put("category", "Sports");
		slcricketsinhala.put("link", "http://apps.appzone.lk/#app_31");
		
		apps.put("108", slcricketsinhala);
		/*End SLCricket(Sinhala)*/
		/* English Premier League */
		HashMap<String,Object> englishpremierleague = new HashMap<String,Object>();
		englishpremierleague.put("appname", "English Premier League");
		englishpremierleague.put("description", "Subscribe to daily alerts and updates of the English " +
				"Premier League matches. Rs.30 per month.\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		englishpremierleague.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		englishpremierleague.put("appimg", R.drawable.etisalat);
		englishpremierleague.put("fields", "REG EPL,STOP EPL");
		englishpremierleague.put("button_replacements", "Register,Unregister");
		englishpremierleague.put("subscription", true);
		englishpremierleague.put("category", "Sports");
		englishpremierleague.put("link", "http://apps.appzone.lk/#app_44");
		
		apps.put("109", englishpremierleague);
		/*End English Premeir League)*/
		/* IntlCrick */
		HashMap<String,Object> intlcrick = new HashMap<String,Object>();
		intlcrick.put("appname", "IntlCrick");
		intlcrick.put("description", "Subscribe to cricket updates and alerts on all International " +
				"matches played other than Srilanka. 30 cents per receiving SMS.\n" +
				"Cost : 0.30\n" +
				"by Etisalat");
		intlcrick.put("help","Press the Register button to register and the " +
				"Unregister button to unregister.\n");
		intlcrick.put("appimg", R.drawable.intlcrick);
		intlcrick.put("fields", "CRICKALL,STOP CRICKALL");
		intlcrick.put("button_replacements", "Register,Unregister");
		intlcrick.put("subscription", true);
		intlcrick.put("category", "Sports");
		intlcrick.put("link", "http://apps.appzone.lk/#app_32");
		
		apps.put("110", intlcrick);
		/*End IntlCrick*/
		/*-------------------------------------END SPORTS SECTION--------------------------*/
		
		/*-------------------------------------GAMES SECTION-------------------------------*/
		/* Word Puzzle */
		HashMap<String,Object> wordpuzzle = new HashMap<String,Object>();
		wordpuzzle.put("appname", "Word Puzzle");
		wordpuzzle.put("description", "Word Puzzle is a SMS based word game with lot of features. " +
				"Users can get marks by identifying the puzzled words with the help of the given meaning " +
				"for each word. This game gives you the option to chose the game mode (hard or easy). " +
				"Hard mode gives more marks than the easy mode and the user is provided with 3 trials " +
				"to guess a word. If the user is unable to identify the word with in the three trials " +
				"they will lose marks. Levels will be updated according to the marks scored. " +
				"From level to level the the game will be more difficult and indeed exciting! Users " +
				"can check their ranks among the other players.\n" +
				"Cost : 5.0\n" +
				"by tharindud");
		wordpuzzle.put("help","To register hit the Register button.\n" +
				"To dergister hit the Unregister button.\n" +
				"To join the game press the Join button.\n" +
				"To start the game press the Start button.\n" +
				"To guess a puzzled word type the guessed word in the text field and press the Send Word button.\n" +
				"To check the rank press the View Rank button.\n" +
				"To Change the mode press the Change Mode button.\n" +
				"To get help type press the Help button.\n" +
				"To change the nick name press the Change Nickname button.\n");
		wordpuzzle.put("appimg", R.drawable.wordpuzzle);
		wordpuzzle.put("fields", "REG PZL,UNREG PZL,PZL JOIN,PZL START,PZL WORD $word,PZL RANK,PZL MODE,PZL HELP,PZL CHNG");
		wordpuzzle.put("button_replacements","Register,Unregister,Join,Start,Send Word,View Rank,Change Mode,Help,Change Nickname");
		wordpuzzle.put("subscription", true);
		wordpuzzle.put("category", "Games");
		wordpuzzle.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("6", wordpuzzle);
		/*End Word Puzzle*/
		/* Tuck Tick Took */
		HashMap<String,Object> tuckticktook = new HashMap<String,Object>();
		tuckticktook.put("appname", "Tuck Tick Took");
		tuckticktook.put("description", "This is a Playable Tic-Tac-Toe Game via SMS. " +
				"Two players can play the game in normal way." +
				"Connecting (known) two players to play Tic-Tac-Toe game in Live through short messages. " +
				"Many pair of players can play Tic-Tac-Toe in one Instance.\n " +
				"Cost : 30.0\n" +
				"by HarshaDura");
		tuckticktook.put("help","To Register press Register\n" +
				"For help press Help\n" +
				"To deregister press Unregister.\n" +
				"For more Details Visit :http://www.ticapp.tk \n");
		tuckticktook.put("appimg", R.drawable.tuckticktook);
		tuckticktook.put("fields", "REG TICK,UNREG TICK,TICK HELP");
		tuckticktook.put("button_replacements","Register,Unregister,Help");
		tuckticktook.put("subscription", true);
		tuckticktook.put("category", "Games");
		tuckticktook.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("11", tuckticktook);
		/*End Tuck Tick Took*/
		/* SMS Soccer */
		HashMap<String,Object> smssoccer = new HashMap<String,Object>();
		smssoccer.put("appname", "SMS Soccer");
		smssoccer.put("description", "This is a penalty shoot out game, where you can " +
				"either choose to strike or defend the goal.\n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		smssoccer.put("help", "To register press Register. " +
				" To get help message press Help\n");
		smssoccer.put("appimg", R.drawable.smssoccer);
		smssoccer.put("fields", "SC PLAY,SC HELP");
		smssoccer.put("button_replacements","Register,Help");
		smssoccer.put("subscription", true);
		smssoccer.put("category", "Games");
		smssoccer.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("13", smssoccer);
		/*End SMS Soccer*/
		/* Play KATA */
		HashMap<String,Object> playkata = new HashMap<String,Object>();
		playkata.put("appname", "Play KATA");
		playkata.put("description", "This is a subscription based game application which can " +
				"be played through SMS. To Register with the Game press the REG KATA Button.\n" +
				"Cost : 30.0\n" +
				"by  madura");
		playkata.put("help", "To join with a game type your nickname and press Join\n" +
				"For help press the Help button.\n" +
				"To play the game type your choice and press the Send button. \n");
		playkata.put("appimg", R.drawable.playkata);
		playkata.put("fields", "REG KATA,KATA JOIN $nickname,KATA $game,KATA HELP");
		playkata.put("button_replacements", "Register,Join,Send,Help");
		playkata.put("subscription", true);
		playkata.put("category", "Games");
		playkata.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("16", playkata);
		/* End Play Kata*/
		/* Spell Master */
		HashMap<String,Object> spellmaster = new HashMap<String,Object>();
		spellmaster.put("appname", "Spell Master");
		spellmaster.put("description", "Application to play Spelling games at nine levels from " +
				"complete beginner to most advanced.Words are given with their pronunciation to " +
				"complete the missing letters.Helps to improve English spelling skills.\n " +
				"Cost : 30.0 \n" +
				"by priyantha");
		spellmaster.put("help", "To Register press the Register button." +
				"To get Help press the Help button.To set Level and Play type a level from 1-9 " +
				"and press the Play button.To Quit and view Stats type press the Quit button." +
				"To Un-Register press the Unregister button.");
		spellmaster.put("appimg", R.drawable.spellmaster);
		spellmaster.put("fields", "REG SM,SM,SM $level,SM Q,UNREG SM");
		spellmaster.put("button_replacements", "Register,Help,Start Level,Quit,Unregister");
		spellmaster.put("subscription", true);
		spellmaster.put("category", "Games");
		spellmaster.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("50", spellmaster);
		/*End Spell Master*/
		/* Guess Jumble Word */
		HashMap<String,Object> guessjumbleword = new HashMap<String,Object>();
		guessjumbleword.put("appname", "Guess Jumble Word");
		guessjumbleword.put("description", "A jumbled word is send to the client and the " +
				"client has to guess the word reply it.\n" +
				"Cost : 30.0\n" +
				"by asankan");
		guessjumbleword.put("help", "To register type press Register To unregister type " +
				"Unregister To join type your nickname in the text field and press Join To start press " +
				"Start To check score press Score To get the rank press Rank");
		guessjumbleword.put("appimg", R.drawable.guessjumbleword);
		guessjumbleword.put("fields", "REG JMBL,UNREG JMBL,JMBL JOIN $nickname,JMBL STRT,JMBL SCOR,JMBL RANK");
		guessjumbleword.put("button_replacements", "Register,Unregister,Join,Start,Score,Rank");
		guessjumbleword.put("subscription", true);
		guessjumbleword.put("category", "Games");
		guessjumbleword.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("51", guessjumbleword);
		/* End Guess Jumble Word */
		/* SMS Speed */
		HashMap<String,Object> smsspeed = new HashMap<String,Object>();
		smsspeed.put("appname", "SMSSpeed");
		smsspeed.put("description", "SMS-Speed is a SMS based competition, where users sent a " +
				"word to type and are evaluated based on the typing speed. \n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		smsspeed.put("help", "To register press " +
				"Register,Help menu press Help.");
		smsspeed.put("appimg", R.drawable.smsspeed);
		smsspeed.put("fields", "SP PLAY,SP HELP");
		smsspeed.put("button_replacements", "Register,Help");
		smsspeed.put("subscription", true);
		smsspeed.put("category", "Games");
		smsspeed.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("52", smsspeed);
		/* End SMSSpeed */
		/* Tough Words */
		HashMap<String,Object> toughwords = new HashMap<String,Object>();
		toughwords.put("appname", "Tough Words");
		toughwords.put("description", "Application to spell difficult English words." +
				"Tough Words are given with missing letters to complete.\n" +
				"Cost : 5.0\n" +
				"by priyantha");
		toughwords.put("help", "To Play press the Play button. " +
				"To get Help:press the Help button.");
		toughwords.put("appimg", R.drawable.toughwords);
		toughwords.put("fields", "TW,TW H");
		toughwords.put("button_replacements", "Play,Help");
		toughwords.put("subscription", false);
		toughwords.put("category", "Games");
		toughwords.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("53", toughwords);
		/* End Tough Words */
		/* Spell King */
		HashMap<String,Object> spellking = new HashMap<String,Object>();
		spellking.put("appname", "Spell King");
		spellking.put("description", "SMS based game where users can guess the correct word for " +
				"a given jumble word. \n" +
				"Cost : 5.0\n" +
				"by Duleepa");
		spellking.put("help", "To use the application press the Play button, users can get " +
				"help by pressing the Help button.");
		spellking.put("appimg", R.drawable.spellking);
		spellking.put("fields", "SPELL,SPELL HELP");
		spellking.put("button_replacements", "Play,Help");
		spellking.put("subscription", false);
		spellking.put("category", "Games");
		spellking.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("53", spellking);
		/* End Spell King */
		/* MasterMind */
		HashMap<String,Object> mastermind = new HashMap<String,Object>();
		mastermind.put("appname", "MasterMind");
		mastermind.put("description", "SMS Based Mastermind Challenge game where players can " +
				"enjoy playing single player and Two Player version of the game with " +
				"another player.\n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		mastermind.put("help", "To register press Play, to start game " +
				"press Start; For Help press Help");
		mastermind.put("appimg", R.drawable.mastermind);
		mastermind.put("fields", "MM PLAY,MM HELP,MM START");
		mastermind.put("button_replacements", "Play,Help,Start");
		mastermind.put("subscription", false);
		mastermind.put("category", "Games");
		mastermind.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("55", mastermind);
		/* End MasterMind */
		
		/*-----------------------------------END GAMES SECTION-------------------------------*/
		
		/*-----------------------------------NEWS SECTION-----------------------------------*/
		/* Technology News */
		HashMap<String,Object> technologynews = new HashMap<String,Object>();
		technologynews.put("appname", "Technology News");
		technologynews.put("description", "Stay up to date with the Latest Technology News across the " +
				"world. This application gives technology news for hardware, software, gadgets, mobile " +
				"phones, etc. \n" +
				"Cost : 30.0\n" +
				"by Haneez");
		technologynews.put("help","To register press the Register button. To deregister press the " +
				"Unregister button.");
		technologynews.put("appimg", R.drawable.technologynews);
		technologynews.put("fields", "REG TECH,UNREG TECH");
		technologynews.put("button_replacements", "Register,Unregister");
		technologynews.put("subscription", true);
		technologynews.put("category", "News");
		technologynews.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("7", technologynews);
		/*End Technology News*/
		/* Daily Mirror */
		HashMap<String,Object> dailymirror = new HashMap<String,Object>();
		dailymirror.put("appname", "Daily Mirror");
		dailymirror.put("description", "Subscribe to the Daily Mirror news service from the " +
				"reliable publication Wijaya Newspapers. Rs.30 per month, 1st 15 days FREE.\n " +
				"Cost : 30.0\n" +
				"by Etisalat");
		dailymirror.put("help","To subscribe press the Register button; To deregister " +
				"press the Unregister button.\n");
		dailymirror.put("appimg", R.drawable.dailymirror);
		dailymirror.put("fields", "DM,STOP DM");
		dailymirror.put("button_replacements", "Register,Unregister");
		dailymirror.put("subscription", true);
		dailymirror.put("category", "News");
		dailymirror.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("20", dailymirror);
		/*End Daily Mirror*/
		/* Virakesari */
		HashMap<String,Object> virakesari = new HashMap<String,Object>();
		virakesari.put("appname", "Virakesari");
		virakesari.put("description", "Subscribe to the Virakesari news service. " +
				"Rs.30 per month, 1st 15 days FREE,\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		virakesari.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		virakesari.put("appimg", R.drawable.virakesari);
		virakesari.put("fields", "REG VK,STOP VK");
		virakesari.put("button_replacements", "Register,Unregister");
		virakesari.put("subscription", true);
		virakesari.put("category", "News");
		virakesari.put("link", "http://apps.appzone.lk/#app_48");
		
		apps.put("56", virakesari);
		/*End Virakesari */
		/* Ada Derana */
		HashMap<String,Object> adaderana = new HashMap<String,Object>();
		adaderana.put("appname", "Ada Derana");
		adaderana.put("description", "Subscribe to the Ada Derana news service. " +
				"Rs.30 per month, 1st 15 days FREE \n" +
				"Cost : 30.0\n" +
				"by Etisalat");
		adaderana.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		adaderana.put("appimg", R.drawable.adaderana);
		adaderana.put("fields", "AD,STOP AD");
		adaderana.put("button_replacements", "Register,Unregister");
		adaderana.put("subscription", true);
		adaderana.put("category", "News");
		adaderana.put("link", "http://apps.appzone.lk/#app_34");
		
		apps.put("57", adaderana);
		/*End Ada Derana */
		/* Hiru FM News */
		HashMap<String,Object> hirufmnews = new HashMap<String,Object>();
		hirufmnews.put("appname", "Hiru FM News");
		hirufmnews.put("description", "Subscribe to the HIRU FM news service. Rs.30 per month, " +
				"1st 15 days FREE\n" +
				"Cost : 30.0\n" +
				"by Etisalat");
		hirufmnews.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		hirufmnews.put("appimg", R.drawable.hirufmnews);
		hirufmnews.put("fields", "HIRU,STOP HIRU");
		hirufmnews.put("button_replacements", "Register,Unregister");
		hirufmnews.put("subscription", true);
		hirufmnews.put("category", "News");
		hirufmnews.put("link", "http://apps.appzone.lk/#app_35");
		
		apps.put("58", hirufmnews);
		/*End Hiru FM News */
		/* Gold FM */
		HashMap<String,Object> goldfm = new HashMap<String,Object>();
		goldfm.put("appname", "Gold FM");
		goldfm.put("description", "Subscribe to the GOLD FM news service. Rs.30 per month, " +
				"1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		goldfm.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		goldfm.put("appimg", R.drawable.goldfm);
		goldfm.put("fields", "GOLD,STOP GOLD");
		goldfm.put("button_replacements", "Register,Unregister");
		goldfm.put("subscription", true);
		goldfm.put("category", "News");
		goldfm.put("link", "http://apps.appzone.lk/#app_36");
		
		apps.put("59", goldfm);
		/*End Gold FM */
		/* Sooriyan FM */
		HashMap<String,Object> sooriyanfm = new HashMap<String,Object>();
		sooriyanfm.put("appname", "Sooriyan FM");
		sooriyanfm.put("description", "Subscribe to the Sooriyan FM news service. Rs.30 per month, " +
				"1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		sooriyanfm.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		sooriyanfm.put("appimg", R.drawable.sooriyanfm);
		sooriyanfm.put("fields", "REG SOORIYAN,STOP SOORIYAN");
		sooriyanfm.put("button_replacements", "Register,Unregister");
		sooriyanfm.put("subscription", true);
		sooriyanfm.put("category", "News");
		sooriyanfm.put("link", "http://apps.appzone.lk/#app_49");
		
		apps.put("60", sooriyanfm);
		/*End Sooriyan FM */
		/* JNW News */
		HashMap<String,Object> jnwnews = new HashMap<String,Object>();
		jnwnews.put("appname", "JNW News");
		jnwnews.put("description", "Subscribe to the news service from Sanit JNW. Rs.30 per month, " +
				"1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		jnwnews.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		jnwnews.put("appimg", R.drawable.jnwnews);
		jnwnews.put("fields", "REG NEWS,STOP NEWS");
		jnwnews.put("button_replacements", "Register,Unregister");
		jnwnews.put("subscription", true);
		jnwnews.put("category", "News");
		jnwnews.put("link", "http://apps.appzone.lk/#app_50");
		
		apps.put("61", jnwnews);
		/*End JNW News */
		/* Vimasuma */
		HashMap<String,Object> vimasuma = new HashMap<String,Object>();
		vimasuma.put("appname", "Vimasuma");
		vimasuma.put("description", "Subscribe to the news service in Sinahala from Vimasuma." +
				" Rs.30 per month, 1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		vimasuma.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		vimasuma.put("appimg", R.drawable.vimasuma);
		vimasuma.put("fields", "REG VIM,STOP VIM");
		vimasuma.put("button_replacements", "Register,Unregister");
		vimasuma.put("subscription", true);
		vimasuma.put("category", "News");
		vimasuma.put("link", "http://apps.appzone.lk/#app_51");
		
		apps.put("62", vimasuma);
		/*End Vimasuma */
		/* LBO News */
		HashMap<String,Object> lbonews = new HashMap<String,Object>();
		lbonews.put("appname", "LBO News");
		lbonews.put("description", "Subscribe to the news service from LBO." +
				" Rs.30 per month, 1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		lbonews.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		lbonews.put("appimg", R.drawable.lbonews);
		lbonews.put("fields", "REG LBO,STOP LBO");
		lbonews.put("button_replacements", "Register,Unregister");
		lbonews.put("subscription", true);
		lbonews.put("category", "News");
		lbonews.put("link", "http://apps.appzone.lk/#app_52");
		
		apps.put("63", lbonews);
		/*End LBO News */
		/* News in Sinhala */
		HashMap<String,Object> newsinsinhala = new HashMap<String,Object>();
		newsinsinhala.put("appname", "News in Sinhala");
		newsinsinhala.put("description", "Subscribe to the Sinhala news service from Sanit JNW." +
				" Rs.30 per month, 1st 15 days FREE\n" +
				"Cost : 1.0\n" +
				"by Etisalat");
		newsinsinhala.put("help"," To subscribe press the Register button, " +
				"To deregister press the Unregister button.");
		newsinsinhala.put("appimg", R.drawable.newsinsinhala);
		newsinsinhala.put("fields", "REG SIN,STOP SIN");
		newsinsinhala.put("button_replacements", "Register,Unregister");
		newsinsinhala.put("subscription", true);
		newsinsinhala.put("category", "News");
		newsinsinhala.put("link", "http://apps.appzone.lk/#app_53");
		
		apps.put("64", newsinsinhala);
		/*End News in Sinhala */
		
		/*------------------------------------------END NEWS SECTION-------------------------------*/
		
		/*------------------------------------------ENTERTAINMENT SECTION------------------------*/
		/* Coming Soon */
		HashMap<String,Object> comingsoon = new HashMap<String,Object>();
		comingsoon.put("appname", "Coming Soon");
		comingsoon.put("description", "New Movie and music releases around the world can be instantly " +
				"informed via sms.\n" +
				"Cost : 30.0\n" +
				"by Chinthaka");
		comingsoon.put("help", "To register, press the Register button.\n" +
				"To unregister, press the Unregister button.");
		comingsoon.put("appimg", R.drawable.comingsoon);
		comingsoon.put("fields", "REG CS,UNREG CS");
		comingsoon.put("button_replacements", "Register,Unregister");
		comingsoon.put("subscription", true);
		comingsoon.put("category", "Entertainment");
		comingsoon.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("8", comingsoon);
		/*End Coming Soon*/
		/*---------------------------------------END ENTERTAINMENT SECTION-------------------------*/
		
		/*---------------------------------------HEALTH SECTION------------------------------------*/
		/* VOG SMS */
		HashMap<String,Object> vogsms = new HashMap<String,Object>();
		vogsms.put("appname", "VOG SMS");
		vogsms.put("description", "VOG SMS is a SMS alert system. Pregnant mothers can register " +
				"to the system by sending SMS specifying the LRMP (Last Regular Menstrual Period) date." +
				" The system automatically calculate the pregnancy period and sends alerts every " +
				"day morning which correspond to that time period. \n" +
				"Cost : 30.0 \n" +
				"by kumudul");
		vogsms.put("help", "To register type LRMP date as yyyy-mm-dd and press Register " +
				"Ex: 2010-12-21 \n" +
				"For help press Help\n" +
				"To deregister press Unregister\n " +
				"LRMP : Last Regular Menstrual Period. For more details www.vog.lk \n");
		vogsms.put("appimg", R.drawable.vogsms);
		vogsms.put("fields", "REG VOG $lrmp,UNREG VOG,VOG HELP");
		vogsms.put("button_replacements", "Register,Unregister,Help");
		vogsms.put("subscription", true);
		vogsms.put("category", "Health");
		vogsms.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("14", vogsms);
		/* End VOG SMS */
		/* Saru Kalaya */
		HashMap<String,Object> sarukalaya = new HashMap<String,Object>();
		sarukalaya.put("appname", "Saru Kalaya");
		sarukalaya.put("description", "Application will send fertile period when the user send " +
				"the last menstrual date with the menstrual period.\n " +
				"Cost : 5.0\n" +
				"by kumudul");
		sarukalaya.put("help", "Type <menstrual date(YYYY/MM/DD)><menstrual period> and press the Send Details button.\n" +
				"For help press the Help button.\n" +
				"E.g. If your menstrual date is 20011/01/02 and menstrual period is 31 then " +
				"type 2011/01/02<space>31.\n");
		sarukalaya.put("appimg", R.drawable.sarukalaya);
		sarukalaya.put("fields", "SARU $date,SARU HELP");
		sarukalaya.put("button_replacements", "Send Details,Help");
		sarukalaya.put("subscription", false);
		sarukalaya.put("category", "Health");
		sarukalaya.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("15", sarukalaya);
		/* End Saru Kalaya */
		/* Sexual Health Quiz */
		HashMap<String,Object> sexualhealthquiz = new HashMap<String,Object>();
		sexualhealthquiz.put("appname", "Sexual Health Quiz");
		sexualhealthquiz.put("description", "Sexual Health Quiz is a mobile health education " +
				"game.\n" +
				"Cost : 30.0\n" +
				"by Roshan");
		sexualhealthquiz.put("help", "Press Register to register. Press Join to join with the" +
				"quiz.");
		sexualhealthquiz.put("appimg", R.drawable.sexualhealthquiz);
		sexualhealthquiz.put("fields", "REG SHQ,SHQ JOIN");
		sexualhealthquiz.put("button_replacements", "Register,Join");
		sexualhealthquiz.put("subscription", true);
		sexualhealthquiz.put("category", "Health");
		sexualhealthquiz.put("link", "http://apps.appzone.lk/#app_244");
		
		apps.put("95", sexualhealthquiz);
		/* End Sexual Health Quiz */
		/* Private Hospital Guide */
		HashMap<String,Object> privatehospitalguide = new HashMap<String,Object>();
		privatehospitalguide.put("appname", "Hospital Guide");
		privatehospitalguide.put("description", "This application provides the contact details " +
				"and addresses of all the private hospitals and nursing homes which are " +
				"registered under Association of Private Hospitals and Nursing homes.\n" +
				"Cost : 5.0\n" +
				"by Roshan");
		privatehospitalguide.put("help", "Type the name of the hospital and press Get Details" +
				"to get details. Press Help for help.");
		privatehospitalguide.put("appimg", R.drawable.privatehospitalguide);
		privatehospitalguide.put("fields", "PH $hospital,PH HELP");
		privatehospitalguide.put("button_replacements", "Get Details,Help");
		privatehospitalguide.put("subscription", false);
		privatehospitalguide.put("category", "Health");
		privatehospitalguide.put("link", "http://apps.appzone.lk/#app_232");
		
		apps.put("96", privatehospitalguide);
		/* Private Hospital Guide */
		/* BMI Calculator */
		HashMap<String,Object> bmicalculator = new HashMap<String,Object>();
		bmicalculator.put("appname", "BMI Calculator");
		bmicalculator.put("description", "Attention! Obesity can kill! Being overweight can " +
				"lead to Diabetes, Hypertension & Kidney Failure. Don't be a statistic! " +
				"Use our BMI Calculator & Stay Healthy!\n" +
				"Cost : 5.0\n" +
				"by Lanka Doctor");
		bmicalculator.put("help", "Type <weight in KG><space><height in cm><space><sex 'M' if " +
				"you are male or 'F' if you are female> and press Calculate to calculate your " +
				"BMI. Press Help for help.");
		bmicalculator.put("appimg", R.drawable.bmicalculator);
		bmicalculator.put("fields", "DOCTOR $details,DOCTOR BMI");
		bmicalculator.put("button_replacements", "Calculate,Help");
		bmicalculator.put("subscription", false);
		bmicalculator.put("category", "Health");
		bmicalculator.put("link", "http://apps.appzone.lk/#app_101");
		
		apps.put("97", bmicalculator);
		/* BMI Calculator */
		/*---------------------------------------END HEALTH SECTION--------------------------------*/
		
		/*---------------------------------------INFORMATION SECTION-------------------------------*/
		/* Cinema */
		HashMap<String,Object> cinema = new HashMap<String,Object>();
		cinema.put("appname", "Cinema");
		cinema.put("description", "SMS based application to retrieve instant info from the cinema " +
				"world.  " +
				"Cost : 5.0 \n" +
				"by Haneez");
		cinema.put("help", "To use type the city name in the text field and press the Send button," +
				" press the Help button for help.");
		cinema.put("appimg", R.drawable.cinema);
		cinema.put("fields", "CINEMA $city,CINEMA HELP");
		cinema.put("button_replacements", "Send,Help");
		cinema.put("subscription", false);
		cinema.put("category", "Information");
		cinema.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("4", cinema);
		/*End Cinema*/
		/* Daily Hadees */
		HashMap<String,Object> dailyhadees = new HashMap<String,Object>();
		dailyhadees.put("appname", "Daily Hadees");
		dailyhadees.put("description", "Receive a Hadees daily from most famous books " +
				"(Ex.Buhari, Muslim etc). \n" +
				"Cost : 30.0\n" +
				"by Suhail Jamaldeen");
		dailyhadees.put("help", "Press Register to subscribe. " +
				"To deregister type press the Unregister button.");
		dailyhadees.put("appimg", R.drawable.dailyhadees);
		dailyhadees.put("fields", "REG HADEES,UNREG HADEES");
		dailyhadees.put("button_replacements", "Register,Unregister");
		dailyhadees.put("subscription", true);
		dailyhadees.put("category", "Information");
		dailyhadees.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("18", dailyhadees);
		/*End Daily Hadees*/
		/* Beautiful Life Quotes */
		HashMap<String,Object> beautifullifequotes = new HashMap<String,Object>();
		beautifullifequotes.put("appname", "Beautiful Life Quotes");
		beautifullifequotes.put("description", "Beautiful Life Quotes is a collection of inspirational " +
				"quotes on topics including success, life, leadership, love, motivation and more. " +
				"Once you register you will get a beautiful quotes every day morning.\n" +
				"Cost : 30.0\n" +
				"by Dilan");
		beautifullifequotes.put("help", "Press Register to subscribe.");
		beautifullifequotes.put("appimg", R.drawable.beautifullifequotes);
		beautifullifequotes.put("fields", "REG QUOTES");
		beautifullifequotes.put("button_replacements", "Register");
		beautifullifequotes.put("subscription", true);
		beautifullifequotes.put("category", "Information");
		beautifullifequotes.put("link", "http://apps.appzone.lk/#app_257");
		
		apps.put("65", beautifullifequotes);
		/*End Beautiful Life Quotes*/
		/* Love Tips */
		HashMap<String,Object> lovetips = new HashMap<String,Object>();
		lovetips.put("appname", "Love Tips");
		lovetips.put("description", "Love advice,love tips,romantic ideas,love quote,dating advice," +
				"relationship advice and more about love.This Application is all about LOVE.\n" +
				"Cost : 30.0\n" +
				"by Amila Silva");
		lovetips.put("help", "Press Register to subscribe, and Unregister to unsubscribe. " +
				"Press the Help button for help, and the About button to get details on the developer.");
		lovetips.put("appimg", R.drawable.beautifullifequotes);
		lovetips.put("fields", "REG LV,UNREG LV,LV HELP,LV ABT");
		lovetips.put("button_replacements", "Register,Unregister,Help,About");
		lovetips.put("subscription", true);
		lovetips.put("category", "Information");
		lovetips.put("link", "http://apps.appzone.lk/#app_276");
		
		apps.put("66", lovetips);
		/*End Love Tips*/
		/* Lowa Puduma Thorathuru */
		HashMap<String,Object> lowapudumathorathuru = new HashMap<String,Object>();
		lowapudumathorathuru.put("appname", "Lowa Puduma Thorathuru");
		lowapudumathorathuru.put("description", "Get world�s amazing facts in singlish everyday via SMS.\n" +
				"Cost : 30.0\n" +
				"by S.Muthukuda");
		lowapudumathorathuru.put("help", "Press Register to subscribe, and Unregister to unsubscribe. ");
		lowapudumathorathuru.put("appimg", R.drawable.lowapudumathorathuru);
		lowapudumathorathuru.put("fields", "REG LOWA,UNREG LOWA");
		lowapudumathorathuru.put("button_replacements", "Register,Unregister");
		lowapudumathorathuru.put("subscription", true);
		lowapudumathorathuru.put("category", "Information");
		lowapudumathorathuru.put("link", "http://apps.appzone.lk/#app_264");
		
		apps.put("67", lowapudumathorathuru);
		/*End Lowa Puduma Thorathuru*/
		/* Lassana Wenna Updates */
		HashMap<String,Object> lassanawennaupdates = new HashMap<String,Object>();
		lassanawennaupdates.put("appname", "Lassana Wenna Updates");
		lassanawennaupdates.put("description", "Get tips on how to be beautiful to your phone in " +
				"Singlish everyday.\n" +
				"Cost : 30.0\n" +
				"by Malaka Premasiri");
		lassanawennaupdates.put("help", "Press Register to register, and Unregister to unregister. ");
		lassanawennaupdates.put("appimg", R.drawable.lassanawennaupdates);
		lassanawennaupdates.put("fields", "REG LW,UNREG LW");
		lassanawennaupdates.put("button_replacements", "Register,Unregister");
		lassanawennaupdates.put("subscription", true);
		lassanawennaupdates.put("category", "Information");
		lassanawennaupdates.put("link", "http://apps.appzone.lk/#app_271");
		
		apps.put("68", lassanawennaupdates);
		/*End Lassana Wenna Updates*/
		/* Saamanya Danuma in Sinhala */
		HashMap<String,Object> saamanyadanumainsinhala = new HashMap<String,Object>();
		saamanyadanumainsinhala.put("appname", "Saamanya Danuma in Sinhala");
		saamanyadanumainsinhala.put("description", "Get a general knowledge tip everyday in " +
				"Singlish.\n" +
				"Cost : 30.0\n" +
				"by T.M.W.P Tennakoon");
		saamanyadanumainsinhala.put("help", "Press Register to register, and Unregister to unregister." +
				"For help, press Help. ");
		saamanyadanumainsinhala.put("appimg", R.drawable.saamanyadanumainsinhala);
		saamanyadanumainsinhala.put("fields", "REG SD,UNREG SD,SD HELP");
		saamanyadanumainsinhala.put("button_replacements", "Register,Unregister,Help");
		saamanyadanumainsinhala.put("subscription", true);
		saamanyadanumainsinhala.put("category", "Information");
		saamanyadanumainsinhala.put("link", "http://apps.appzone.lk/#app_267");
		
		apps.put("69", saamanyadanumainsinhala);
		/*End Saamanya Danuma in Sinhala*/
		/* Bollywood Gossip in Sinhala */
		HashMap<String,Object> bollywoodgossipinsinhala = new HashMap<String,Object>();
		bollywoodgossipinsinhala.put("appname", "Bollywood Gossip in Sinhala");
		bollywoodgossipinsinhala.put("description", "Get the latest & hottest Bollywood gossip " +
				"to you phone in singlish everyday via SMS.\n" +
				"Cost : 30.0\n" +
				"by Malaka Premasiri");
		bollywoodgossipinsinhala.put("help", "Press Register to register, and Unregister to unregister." +
				"For help, press Help. ");
		bollywoodgossipinsinhala.put("appimg", R.drawable.bollywoodgossipinsinhala);
		bollywoodgossipinsinhala.put("fields", "REG BOLY,UNREG BOLY,BOLY HELP");
		bollywoodgossipinsinhala.put("button_replacements", "Register,Unregister,Help");
		bollywoodgossipinsinhala.put("subscription", true);
		bollywoodgossipinsinhala.put("category", "Information");
		bollywoodgossipinsinhala.put("link", "http://apps.appzone.lk/#app_273");
		
		apps.put("70", bollywoodgossipinsinhala);
		/*End Bollywood Gossip in Sinhala*/
		/* English Grammar Tips */
		HashMap<String,Object> englishgrammartips = new HashMap<String,Object>();
		englishgrammartips.put("appname", "English Grammar Tips");
		englishgrammartips.put("description", "Get English grammar tips everyday and improve your" +
				" knowledge on English grammar.\n" +
				"Cost : 30.0\n" +
				"by T.M.W.P Tennakoon");
		englishgrammartips.put("help", "Press Register to register, and Unregister to unregister." +
				"For help, press Help. ");
		englishgrammartips.put("appimg", R.drawable.englishgrammartips);
		englishgrammartips.put("fields", "REG EG,UNREG EG,EG HELP");
		englishgrammartips.put("button_replacements", "Register,Unregister,Help");
		englishgrammartips.put("subscription", true);
		englishgrammartips.put("category", "Information");
		englishgrammartips.put("link", "http://apps.appzone.lk/#app_269");
		
		apps.put("71", englishgrammartips);
		/*End English Grammar Tips*/
		/* World's Amazing Facts */
		HashMap<String,Object> worldsamazingfacts = new HashMap<String,Object>();
		worldsamazingfacts.put("appname", "World's Amazing Facts");
		worldsamazingfacts.put("description", "Get world�s amazing facts in English everyday via SMS.\n" +
				"Cost : 30.0\n" +
				"by S.Muthukuda");
		worldsamazingfacts.put("help", "Press Register to register, and Unregister to unregister. ");
		worldsamazingfacts.put("appimg", R.drawable.worldsamazingfacts);
		worldsamazingfacts.put("fields", "REG FACT,UNREG FACT");
		worldsamazingfacts.put("button_replacements", "Register,Unregister");
		worldsamazingfacts.put("subscription", true);
		worldsamazingfacts.put("category", "Information");
		worldsamazingfacts.put("link", "http://apps.appzone.lk/#app_265");
		
		apps.put("72", worldsamazingfacts);
		/*End World's Amazing Facts*/
		/* Beauty Tips */
		HashMap<String,Object> beautytips = new HashMap<String,Object>();
		beautytips.put("appname", "World's Amazing Facts");
		beautytips.put("description", "Get tips on how to be beautiful to your phone in " +
				"English everyday.\n" +
				"Cost : 30.0\n" +
				"by Malaka Premasiri");
		beautytips.put("help", "Press Register to register, and Unregister to unregister. " +
				"Press Help for help.");
		beautytips.put("appimg", R.drawable.beautytips);
		beautytips.put("fields", "REG BTIP,UNREG BTIP,BTIP HELP");
		beautytips.put("button_replacements", "Register,Unregister,Help");
		beautytips.put("subscription", true);
		beautytips.put("category", "Information");
		beautytips.put("link", "http://apps.appzone.lk/#app_270");
		
		apps.put("73", beautytips);
		/*End Beauty Tips*/
		/* General Knowledge Facts in English */
		HashMap<String,Object> generalknowledgefacts = new HashMap<String,Object>();
		generalknowledgefacts.put("appname", "General Knowledge Facts");
		generalknowledgefacts.put("description", "Get a general knowledge tip everyday in English.\n" +
				"Cost : 30.0\n" +
				"by T.M.W.P Tennakoon");
		generalknowledgefacts.put("help", "Press Register to register, and Unregister to unregister. " +
				"Press Help for help.");
		generalknowledgefacts.put("appimg", R.drawable.generalknowledgefacts);
		generalknowledgefacts.put("fields", "REG GK,UNREG GK,GK HELP");
		generalknowledgefacts.put("button_replacements", "Register,Unregister,Help");
		generalknowledgefacts.put("subscription", true);
		generalknowledgefacts.put("category", "Information");
		generalknowledgefacts.put("link", "http://apps.appzone.lk/#app_268");
		
		apps.put("74", generalknowledgefacts);
		/*End General Knowledge Facts*/
		/* Bollywood Gossip in English */
		HashMap<String,Object> bollywoodgossipinenglish = new HashMap<String,Object>();
		bollywoodgossipinenglish.put("appname", "Bollywood Gossip in English");
		bollywoodgossipinenglish.put("description", "Get the latest and hottest Bollywood gossip to " +
				"you phone in English everyday via SMS.\n" +
				"Cost : 30.0\n" +
				"by Malaka Premasiri");
		bollywoodgossipinenglish.put("help", "Press Register to register, and Unregister to unregister. " +
				"Press Help for help.");
		bollywoodgossipinenglish.put("appimg", R.drawable.bollywoodgossipinenglish);
		bollywoodgossipinenglish.put("fields", "REG EBOLY,UNREG EBOLY,EBOLY HELP");
		bollywoodgossipinenglish.put("button_replacements", "Register,Unregister,Help");
		bollywoodgossipinenglish.put("subscription", true);
		bollywoodgossipinenglish.put("category", "Information");
		bollywoodgossipinenglish.put("link", "http://apps.appzone.lk/#app_272");
		
		apps.put("75", bollywoodgossipinenglish);
		/*End General Knowledge Facts*/
		/* Hospitals Guider */
		HashMap<String,Object> hospitalsguider = new HashMap<String,Object>();
		hospitalsguider.put("appname", "Hospitals Guider");
		hospitalsguider.put("description", "To find out the government hospitals telephone numbers " +
				"Cost : 5.0\n" +
				"by shashi");
		hospitalsguider.put("help", "Type the name of the Hospital in the text field and press the " +
				"button to send the message.");
		hospitalsguider.put("appimg", R.drawable.hospitalsguider);
		hospitalsguider.put("fields", "HOS $hospital");
		hospitalsguider.put("button_replacements", "Request Number");
		hospitalsguider.put("subscription", false);
		hospitalsguider.put("category", "Information");
		hospitalsguider.put("link", "http://apps.appzone.lk/#app_119");
		
		apps.put("76", hospitalsguider);
		/*End Hospitals Guider*/
		/* AppZone Post Code */
		HashMap<String,Object> appzonepostcode = new HashMap<String,Object>();
		appzonepostcode.put("appname", "AppZone PostCode");
		appzonepostcode.put("description", "This application gives the Postal Code. District and " +
				"Province of any given City. \n" +
				"Cost : 5.0\n" +
				"by priyantha");
		appzonepostcode.put("help", "Type the name of the Hospital in the text field and press the " +
				"button to send the message.");
		appzonepostcode.put("appimg", R.drawable.appzonepostcode);
		appzonepostcode.put("fields", "POSTCODE $city");
		appzonepostcode.put("button_replacements", "Request Post Code");
		appzonepostcode.put("subscription", false);
		appzonepostcode.put("category", "Information");
		appzonepostcode.put("link", "http://apps.appzone.lk/#app_185");
		
		apps.put("77", appzonepostcode);
		/*End AppZone PostCode*/
		/* AppZoneSweep */
		HashMap<String,Object> appzonesweep = new HashMap<String,Object>();
		appzonesweep.put("appname", "AppZoneSweep");
		appzonesweep.put("description", "This application gives the results of Sri Lankan Sweeps " +
				"(Lottery).\n" +
				"Cost : 5.0\n" +
				"by priyantha");
		appzonesweep.put("help", "Type the draw number and press Get Result to get the latest" +
				"result to a given draw number. Type the draw number followed by a space" +
				"and the sweep number to give the result of a particular sweep and draw number. " +
				"Type the name of a sweep and press Get Result to get the latest result of that " +
				"sweep.");
		appzonesweep.put("appimg", R.drawable.appzonesweep);
		appzonesweep.put("fields", "SWEEP $data");
		appzonesweep.put("button_replacements", "Get Result");
		appzonesweep.put("subscription", true);
		appzonesweep.put("category", "Information");
		appzonesweep.put("link", "http://apps.appzone.lk/#app_112");
		
		apps.put("78", appzonesweep);
		/*End AppZone Sweep*/
		/* BusR */
		HashMap<String,Object> busr = new HashMap<String,Object>();
		busr.put("appname", "BusR");
		busr.put("description", "Get instruction on which bus to take when start and destination" +
				" are given or get the bus path when the bus route number is given.\n " +
				"Cost : 5.0\n" +
				"by Jason Jebanesa");
		busr.put("help", "Type the place you want to take the bus from followed by a space" +
				"and followed by where you want to go and hit Get Details. " +
				"Or type the route number and hit Get Details.");
		busr.put("appimg", R.drawable.busr);
		busr.put("fields", "BUSR $data");
		busr.put("button_replacements", "Get Details");
		busr.put("subscription", false);
		busr.put("category", "Information");
		busr.put("link", "http://apps.appzone.lk/#app_27");
		
		apps.put("79", busr);
		/*End BusR*/
		/* Navigator */
		HashMap<String,Object> navigator = new HashMap<String,Object>();
		navigator.put("appname", "Navigator");
		navigator.put("description", "This application supplies driving instructions from " +
				"origin to a destination via SMS.\n" +
				"Cost : 5.0\n" +
				"by asankas");
		navigator.put("help", "Type the place you want to take the start from followed by a space" +
				"and followed by where you want to go and hit Get Details. " +
				"To get the next set of instructions, hit the Next button.");
		navigator.put("appimg", R.drawable.navigator);
		navigator.put("fields", "NAVIGATE $data,NAVIGATE NEXT");
		navigator.put("button_replacements", "Get Directions,Next");
		navigator.put("subscription", false);
		navigator.put("category", "Information");
		navigator.put("link", "http://apps.appzone.lk/#app_195");
		
		apps.put("80", navigator);
		/*End Navigator*/
		/* Direction of Maru */
		HashMap<String,Object> directionofmaru = new HashMap<String,Object>();
		directionofmaru.put("appname", "Direction of Maru");
		directionofmaru.put("description", "This application sends 'Direction of the Maru' for current " +
				"day or specified day. \n" +
				"Cost : 5.0\n" +
				"by Channa");
		directionofmaru.put("help", "Press Today to get directions for today or type the date in the " +
				"text field and press Other Day to get directions for a different day. " +
				"To get the next set of instructions, hit the Next button.");
		directionofmaru.put("appimg", R.drawable.directionofmaru);
		directionofmaru.put("fields", "MARU,MARU $date");
		directionofmaru.put("button_replacements", "Today,Other Day");
		directionofmaru.put("subscription", false);
		directionofmaru.put("category", "Information");
		directionofmaru.put("link", "http://apps.appzone.lk/#app_121");
		
		apps.put("81", directionofmaru);
		/*End Direction of Maru*/
		/* Rahu Kalaya */
		HashMap<String,Object> rahukalaya = new HashMap<String,Object>();
		rahukalaya.put("appname", "Rahu Kalaya");
		rahukalaya.put("description", "Get the Rahukalaya for the day.\n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		rahukalaya.put("help", "Press the Get Rahu Kalaya button to get the Rahu Kalaya for today.");
		rahukalaya.put("appimg", R.drawable.rahukalaya);
		rahukalaya.put("fields", "RAHU");
		rahukalaya.put("button_replacements", "Get Rahu Kalaya");
		rahukalaya.put("subscription", false);
		rahukalaya.put("category", "Information");
		rahukalaya.put("link", "http://apps.appzone.lk/#app_24");
		
		apps.put("82", rahukalaya);
		/*End Rahu Kalaya*/
		/* Live Weather SMS */
		HashMap<String,Object> liveweathersms = new HashMap<String,Object>();
		liveweathersms.put("appname", "Live Weather SMS");
		liveweathersms.put("description", "This application provides live weather data for below cities." +
				"Ambalangoda, Anuradhapura, Avissawella, Badulla, Balangoda, Battaramulla,Batticaloa,Beruwala," +
				"Chilaw,Colombo,Dehiwala,Elpitiya,Galle, Gampaha,Gampola,Ja Ela,Jaffna,Kalmunai,Kalutara," +
				"Kandy,Kankesanturai, Kattankudi,Kegalla,Kotte,Kurunegala,Mannar,Matale,Matara,Matugama, " +
				"Moratuwa,Nawalapitiya,Negombo,Nuwara Eliya,Panadura,Point Pedro, Polonnaruwa,Puttalam," +
				"Ragama,Ratnapura,Sri Jayavardhanapura,Trincomalee, Vavuniya,Wadduwa,Wattala,Weligama.\n" +
				"Cost : 5.0\n" +
				"by Charitha");
		liveweathersms.put("help", "Type the city name and press the Get Weather button.");
		liveweathersms.put("appimg", R.drawable.liveweathersms);
		liveweathersms.put("fields", "LWR $city");
		liveweathersms.put("button_replacements", "Get Weather");
		liveweathersms.put("subscription", false);
		liveweathersms.put("category", "Information");
		liveweathersms.put("link", "http://apps.appzone.lk/#app_146");
		
		apps.put("83", liveweathersms);
		/*End Live Weather SMS*/
		/* Bank Head Offices */
		HashMap<String,Object> bankheadoffice = new HashMap<String,Object>();
		bankheadoffice.put("appname", "Bank Head Offices");
		bankheadoffice.put("description", "This application gives you the address and the telephone number " +
				"of the head office of any bank within Colombo along with the relevant bus rout numbers.\n" +
				"Cost : 5.0\n" +
				"by dileepa");
		bankheadoffice.put("help", "Type the name of the bank and press the Get Details button.");
		bankheadoffice.put("appimg", R.drawable.bankheadoffice);
		bankheadoffice.put("fields", "BANK $name");
		bankheadoffice.put("button_replacements", "Get Details");
		bankheadoffice.put("subscription", false);
		bankheadoffice.put("category", "Information");
		bankheadoffice.put("link", "http://apps.appzone.lk/#app_155");
		
		apps.put("84", bankheadoffice);
		/*End Bank Head Offices*/
		/* Islamic Prayer Time */
		HashMap<String,Object> islamicprayertime = new HashMap<String,Object>();
		islamicprayertime.put("appname", "Islamic Prayer Time");
		islamicprayertime.put("description", "This application enables you to know the prayer time in " +
				"Western Province and Eastern province.\n" +
				"Cost : 5.0\n" +
				"by Suhail Jamaldeen");
		islamicprayertime.put("help", "Press Western Province for Western Province Prayer times and " +
				"Eastern Province for Eastern Province prayer times");
		islamicprayertime.put("appimg", R.drawable.islamicprayertime);
		islamicprayertime.put("fields", "PRAYER W,PRAYER E");
		islamicprayertime.put("button_replacements", "Western Province,Eastern Province");
		islamicprayertime.put("subscription", false);
		islamicprayertime.put("category", "Information");
		islamicprayertime.put("link", "http://apps.appzone.lk/#app_108");
		
		apps.put("85", islamicprayertime);
		/*End Islamic Prayer Time*/
		/* Stock Market Summary */
		HashMap<String,Object> stockmarketsummary = new HashMap<String,Object>();
		stockmarketsummary.put("appname", "Stock Market Summary");
		stockmarketsummary.put("description", "This application gives stock trade summery via SMS. " +
				"Registered user will receive daily stock trade summery.\n" +
				"Cost : 30.0\n" +
				"by Asanka Ishara");
		stockmarketsummary.put("help", "To register, press Register and press Unregister to deregister." +
				"To get daily summary type <company code 1>,<company code 2> and hit Summary. " +
				"To know trade details type <company code> or <company code1><space><company code2> and press" +
				"Trade Details.");
		stockmarketsummary.put("appimg", R.drawable.stockmarketsummary);
		stockmarketsummary.put("fields", "REG TRADE,UNREG TRADE,TRADE SUMMARY $codes,TRADE $codes");
		stockmarketsummary.put("button_replacements", "Register,Unregister,Summary,Trade Details");
		stockmarketsummary.put("subscription", true);
		stockmarketsummary.put("category", "Information");
		stockmarketsummary.put("link", "http://apps.appzone.lk/#app_208");
		
		apps.put("86", stockmarketsummary);
		/*End Stock Market Summary*/
		/* Stock Trades */
		HashMap<String,Object> stocktrades = new HashMap<String,Object>();
		stocktrades.put("appname", "Stock Trades");
		stocktrades.put("description", "This is a SMS based application for the share holders in CSE. " +
				"User can receive the current trading details (current trade price, today highest price, " +
				"today lowest price) of the companies by sending the company code(s) of one or two companies " +
				"in one message. This application will enable the share holders to be on alert on the share " +
				"prices of the relevant companies via the mobile phone.\n" +
				"Cost : 5.0\n" +
				"by Asanka Ishara");
		stocktrades.put("help", "Type company code or <company code 1><space><company code 2> and hit" +
				"Get Details. Company code should be in standard format(Eg: semb.N0000).");
		stocktrades.put("appimg", R.drawable.stocktrades);
		stocktrades.put("fields", "STOCK $codes");
		stocktrades.put("button_replacements", "Get Details");
		stocktrades.put("subscription", false);
		stocktrades.put("category", "Information");
		stocktrades.put("link", "http://apps.appzone.lk/#app_139");
		
		apps.put("87", stocktrades);
		/*End Stock Trades*/
		/* Holidays */
		HashMap<String,Object> holidays = new HashMap<String,Object>();
		holidays.put("appname", "Holidays");
		holidays.put("description", "This application gives the holidays related to that month.\n" +
				"Cost : 5.0\n" +
				"by Sudeera");
		holidays.put("help", "Type the month and press the Get Holidays button.");
		holidays.put("appimg", R.drawable.holidays);
		holidays.put("fields", "HD $month");
		holidays.put("button_replacements", "Get Holidays");
		holidays.put("subscription", false);
		holidays.put("category", "Information");
		holidays.put("link", "http://apps.appzone.lk/#app_187");
		
		apps.put("88", holidays);
		/*End Holidays*/
		/* Wikipedia Definitions */
		HashMap<String,Object> wikipediadefinitions = new HashMap<String,Object>();
		wikipediadefinitions.put("appname", "Wikipedia Definitions");
		wikipediadefinitions.put("description", "Now for the first time in Sri Lanka, you can search " +
				"You can search Wikipedia unlimited number of times for just Rs.30 per month.\n" +
				"Cost : 30.0\n" +
				"by Bhasha");
		wikipediadefinitions.put("help", "Press Register to register. Then type your search term and " +
				"hit Search to search Wikipedia.");
		wikipediadefinitions.put("appimg", R.drawable.wikipediadefinitions);
		wikipediadefinitions.put("fields", "REG WIKI,REG $term");
		wikipediadefinitions.put("button_replacements", "Register,Search");
		wikipediadefinitions.put("subscription", true);
		wikipediadefinitions.put("category", "Information");
		wikipediadefinitions.put("link", "http://apps.appzone.lk/#app_275");
		
		apps.put("89", wikipediadefinitions);
		/*End Wikipedia Definitions*/
		/* Exchange Rates */
		HashMap<String,Object> exchangerates = new HashMap<String,Object>();
		exchangerates.put("appname", "Exchange Rates");
		exchangerates.put("description", "An application to retrieve Exchange rates. " +
				"To get the LKR value type MONEY<space><amount><space><currency> or To get other " +
				"currency value type MONEY<space><amount><space><currency1><space>TO<space><currency2>" +
				" and send to 4499. For help type MONEY<space>HELP and send to 4499. \n" +
				"Cost : 5.0\n" +
				"by Haneez");
		exchangerates.put("help", "To get LKR value type the amount<space>currency and press LKR." +
				"To get other currencies, type <amount><space><currency1><space>TO<space><currency2> and hit" +
				"Other. For help, press the Help button.");
		exchangerates.put("appimg", R.drawable.exchangerates);
		exchangerates.put("fields", "MONEY $details,MONEY $details,MONEY HELP");
		exchangerates.put("button_replacements", "LKR,Other,Help");
		exchangerates.put("subscription", false);
		exchangerates.put("category", "Information");
		exchangerates.put("link", "http://apps.appzone.lk/#app_130");
		
		apps.put("90", exchangerates);
		/*End Exchange Rates*/
		/* Prayer Times */
		HashMap<String,Object> prayertimes = new HashMap<String,Object>();
		prayertimes.put("appname", "Prayer Times");
		prayertimes.put("description", "This is an useful application for Muslim community, " +
				"which will send prayer times on demand. \n" +
				"Cost : 5.0\n" +
				"by Haneez");
		prayertimes.put("help", "Press the Get Times button.");
		prayertimes.put("appimg", R.drawable.prayertimes);
		prayertimes.put("fields", "AZAN");
		prayertimes.put("button_replacements", "Get Times");
		prayertimes.put("subscription", false);
		prayertimes.put("category", "Information");
		prayertimes.put("link", "http://apps.appzone.lk/#app_132");
		
		apps.put("91", prayertimes);
		/*End Prayer Times*/
		/* Time Reader */
		HashMap<String,Object> timereader = new HashMap<String,Object>();
		timereader.put("appname", "Time Reader");
		timereader.put("description", "Get the time difference between the GMT and the city. \n" +
				"Cost : 5.0\n" +
				"by hSenidMobile");
		timereader.put("help", "Type the name of the city and press Get Difference to check the difference" +
				"between the GMT and the city.");
		timereader.put("appimg", R.drawable.timereader);
		timereader.put("fields", "TIME $city");
		timereader.put("button_replacements", "Get Difference");
		timereader.put("subscription", false);
		timereader.put("category", "Information");
		timereader.put("link", "http://apps.appzone.lk/#app_23");
		
		apps.put("92", timereader);
		/*End Time Reader*/
		/* Colombo Guide */
		HashMap<String,Object> colomboguide = new HashMap<String,Object>();
		colomboguide.put("appname", "Colombo Guide");
		colomboguide.put("description", "Using this application you can retrieve details of the most " +
				"important places located around Colombo.\n" +
				"Cost : 5.0\n" +
				"by Roshan");
		colomboguide.put("help", "1) Type location name and press Get Details if you know the location. " +
				"2) Type the category and press Get Details to see the available categories of locations " +
				"3) Type category<space>LOC to see all the locations available for a " +
				"certain category. " +
				"4) Press Help for help.");
		colomboguide.put("appimg", R.drawable.colomboguide);
		colomboguide.put("fields", "CG $details,CG HELP");
		colomboguide.put("button_replacements", "Get Details,Help");
		colomboguide.put("subscription", false);
		colomboguide.put("category", "Information");
		colomboguide.put("link", "http://apps.appzone.lk/#app_68");
		
		apps.put("93", colomboguide);
		/*End Colombo Guide*/
		/* Lottery Results */
		HashMap<String,Object> lotteryresults = new HashMap<String,Object>();
		lotteryresults.put("appname", "Lottery Results");
		lotteryresults.put("description", "Receive results of all types of lotteries daily. " +
				"Enjoy the first week for free, after that only Rs.7 per week.\n" +
				"Cost : 7.0\n" +
				"by Etisalat");
		lotteryresults.put("help", "Press Register to subscribe, and Stop to deregister.");
		lotteryresults.put("appimg", R.drawable.lotteryresults);
		lotteryresults.put("fields", "REG LOT,STOP LOT");
		lotteryresults.put("button_replacements", "Register,Stop");
		lotteryresults.put("subscription", true);
		lotteryresults.put("category", "Information");
		lotteryresults.put("link", "http://apps.appzone.lk/#app_37");
		
		apps.put("94", lotteryresults);
		/*End Lottery Results*/
		/*---------------------------------------END INFORMATION SECTION-----------------------------*/
		/*---------------------------------------BUSINESS SECTION------------------------------------*/
		/* Biz News */
		HashMap<String,Object> biznews = new HashMap<String,Object>();
		biznews.put("appname", "Biz News");
		biznews.put("description", "This application gives the latest Business News alerts.\n " +
				"Cost : 30.0\n" +
				"by Haneez");
		biznews.put("help","To register with the service press the Register button. " +
				"To deregister press the Unregister button.");
		biznews.put("appimg", R.drawable.biznews);
		biznews.put("fields", "REG BIZ,UNREG BIZ");
		biznews.put("button_replacements", "Register,Unregister");
		biznews.put("subscription", true);
		biznews.put("category", "Business");
		biznews.put("link", "http://apps.appzone.lk/#app_97");
		
		apps.put("19", biznews);
		/*End Biz News*/
		/* Auction */
		HashMap<String,Object> auction = new HashMap<String,Object>();
		auction.put("appname", "Auction");
		auction.put("description", "Within a period of time users can bid for an item " +
				"using sms. The lowest and the unique bid at the end of the auction time " +
				"will win the current prize. Prizes will be announced from time to time.\n" +
				"Cost : 5.0\n" +
				"by Ashen Gomez");
		auction.put("help","To place a bid type your bid and hit the Bid button. Press Help" +
				"for help.");
		auction.put("appimg", R.drawable.auction);
		auction.put("fields", "BID $bid,BID HELP");
		auction.put("button_replacements", "Bid,Help");
		auction.put("subscription", false);
		auction.put("category", "Business");
		auction.put("link", "http://apps.appzone.lk/#app_278");
		
		apps.put("98", auction);
		/*End Auction*/
		/* My Expense Tracker */
		HashMap<String,Object> myexpensetracker = new HashMap<String,Object>();
		myexpensetracker.put("appname", "My Expense Tracker");
		myexpensetracker.put("description", "This application will help to track the users " +
				"expenses and produce them detailed reports.\n" +
				"Cost : 30.0\n" +
				"by Amila Silva");
		myexpensetracker.put("help","Press Register to register and Unregister" +
				"to unregister. " +
				"Type an amount and hit Add to add an expense. " +
				"Press Total to get total expenses of the current month. " +
				"Press Types to list down the available Expense Types. " +
				"Type <date><space><email address> and press Report to post the expense " +
				"report of the given month. " +
				"Press About to get the detail of the app developer. " +
				"Press Help to get and quick help.");
		myexpensetracker.put("appimg", R.drawable.myexpensetracker);
		myexpensetracker.put("fields", "REG ME,UNREG ME,ME ADD $details,ME TOTAL,ME TYPES,ME RPT $details,ME ABT,ME HELP");
		myexpensetracker.put("button_replacements", "Register,Unregister,Add,Total,Types,Report,About,Help");
		myexpensetracker.put("subscription", true);
		myexpensetracker.put("category", "Business");
		myexpensetracker.put("link", "http://apps.appzone.lk/#app_277");
		
		apps.put("99", myexpensetracker);
		/*End My Expense Tracker*/
		/* mMart */
		HashMap<String,Object> mmart = new HashMap<String,Object>();
		mmart.put("appname", "mMart");
		mmart.put("description", "mMart is your SMS classifieds to buy & sell your mobile " +
				"phones!.It�s a revolutionary method for a seller to advertise and for a " +
				"buyer to query phones either based on price or model.Brand name,model and " +
				"contact number must be single words.eg: sonyericsson.\n" +
				"Cost : 5.0\n" +
				"by sureshs");
		mmart.put("help","To Sell type <Phone-brand><space><Phone model><space><Price><space><Contact-no> and press Sell. " +
				"To Search by model type <Brand><space><Model> and press Search Model" +
				"To Search by price type <Brand><space><Price> and press Search Price" +
				"To Cancel a selling type the reference id and press Cancel.");
		mmart.put("appimg", R.drawable.mmart);
		mmart.put("fields", "SELL $details,MT BUYM $details,MT BUYP $details,MT CANCEL $refid");
		mmart.put("button_replacements", "Sell,Search Model,Search Price,Cancel");
		mmart.put("subscription", false);
		mmart.put("category", "Business");
		mmart.put("link", "http://apps.appzone.lk/#app_227");
		
		apps.put("100", mmart);
		/*End mMart*/
		/* Sale */
		HashMap<String,Object> sale = new HashMap<String,Object>();
		sale.put("appname", "Sale");
		sale.put("description", "Sale is the smartest way to meet buyers and sellers.It allows " +
				"sellers to advertise their products instantly.Sellers can create their own " +
				"groups.Buyers can joined to groups of their favourite sellers.Then they get " +
				"to know whenever the seller advertise products via Sale.Same time sellers can " +
				"advertise their products to all the Sale subscribers.\n" +
				"Cost : 30.0\n" +
				"by Manuja Jayamanne");
		sale.put("help","Register to the Application : press Register" +
				"Unregister from the Application : press Unregister." +
				"Unregister from common group : Press Unregister Common." +
				"Re-register to common group : Press Register Common.");
		sale.put("appimg", R.drawable.sale);
		sale.put("fields", "REG SALE,UNREG SALE,SALE REG COM,SALE UNREG COM");
		sale.put("button_replacements", "Register,Unregister,Register Common,Unregister Common");
		sale.put("subscription", true);
		sale.put("category", "Business");
		sale.put("link", "http://apps.appzone.lk/#app_266");
		
		apps.put("101", sale);
		/*End Sale*/
		/* Stock */
		HashMap<String,Object> stock = new HashMap<String,Object>();
		stock.put("appname", "Stock");
		stock.put("description", "Application to receive stock exchange details.\n" +
				"Cost : 30.0\n" +
				"by Jason Jebanesan");
		stock.put("help","Register to the Application : press Register" +
				"Unregister from the Application : press Unregister." +
				"Press Help for help.");
		stock.put("appimg", R.drawable.stock);
		stock.put("fields", "REG ST,UNREG ST,ST HELP");
		stock.put("button_replacements", "Register,Unregister,Help");
		stock.put("subscription", true);
		stock.put("category", "Business");
		stock.put("link", "http://apps.appzone.lk/#app_266");
		
		apps.put("102", stock);
		/*End Stock*/
		
		/*------------------------------------END BUSINESS SECTION-----------------------------------*/
		
	}
}
//134/Other/Metric Converter