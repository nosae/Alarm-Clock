package alarmclock;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;




import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class alarm {

  static Calendar calendar = Calendar.getInstance();

    static int amPm = calendar.get(Calendar.AM_PM);// AM = 0, PM = 1

   // static JButton snooze = new JButton("Snooze");

 

    public static void main(String[] args) throws Exception{


   

    //Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);//January = 0, December = 11

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);

        int minute = calendar.get(Calendar.MINUTE);

      // int amPm = calendar.get(Calendar.AM_PM);// AM = 0, PM = 1

       

        AlarmClock alarm = new AlarmClock(10, 30, 0);

       

   

       

        System.out.println(month + "-" + dayOfMonth + "-" + year);

        //System.out.println(hour + ":" + minute + " " + amPm);

                System.out.println(hour + ":" + minute + " " + getStringAMPM());

        System.out.println(alarm.getalarmHour() + ":" + alarm.getAlarmMinute() + alarm.getAlarmAmPm());

        System.out.println(alarm.isAlarmRinging());

       

        //Static Class to convert 0/1 to AM/PM



      //Frame Build        
        JFrame frame = new JFrame("Alarm Clock");
    //frame.setSize(550, 400);


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   

    //frame.setResizable(true);

   

    JPanel main = new JPanel();

    JPanel bottom = new JPanel();	     

    JPanel datePanel = new JPanel();

    JPanel timePanel = new JPanel();

    JPanel alarmPanel = new JPanel();

    JPanel ipanel = new JPanel();

     

    //JTextField input = new JTextField();

    JTextField iHour = new JTextField("Hour");

    JTextField iMinute = new JTextField("Minute");

    JTextField iAMPM = new JTextField("0(am)/1(pm)");

     

    bottom.setLayout(new GridLayout(1,4));

   

   	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));



   	//input.setPreferredSize(new Dimension( 100, 24 ));

   	iHour.setPreferredSize(new Dimension( 100, 24 ));

   	iMinute.setPreferredSize(new Dimension( 100, 24 ));

   	iAMPM.setPreferredSize(new Dimension( 100, 24 ));

   

    String date =  month + "-" + dayOfMonth + "-" + year;

    String Time =  hour + ":" + minute + " " + getStringAMPM();

    String alarmTime = alarm.getalarmHour() + ":" + alarm.getAlarmMinute() + " " + alarm.getAlarmAmPm() +" ";

    Boolean isAlarm = alarm.isAlarmRinging();

   

     

    //Change background colors

    bottom.setBackground(Color.RED);

   	timePanel.setBackground(Color.BLUE);

   	datePanel.setBackground(Color.PINK);

   	alarmPanel.setBackground(Color.ORANGE);

 

   	//JLabels

   	JLabel cTime1 = new JLabel("Time");

   	JLabel cTime = new JLabel("Current Date");

   	JLabel timeAlarm = new JLabel("Alarm Time");

   	JLabel onoff = new JLabel("on/off");

   

   	//String Date

   	cTime.setText(date);

   	cTime1.setText(Time);

   	timeAlarm.setText(alarmTime);

   	onoff.setText(isAlarm.toString());

     

     

   	//Font

   	cTime1.setFont(new Font("DejaVu Sans", Font.BOLD, 72));

   	cTime.setFont(new Font("DejaVu Sans", Font.BOLD, 56));

   	timeAlarm.setFont(new Font("DejaVu Sans", Font.BOLD, 36));

   	onoff.setFont(new Font("DejaVu Sans", Font.BOLD, 36));

     

   	//Change Text Color

   	cTime1.setForeground(Color.WHITE);

   	cTime.setForeground(Color.WHITE);

   	timeAlarm.setForeground(Color.WHITE);

   	onoff.setForeground(Color.WHITE);

   

     

   	//JButtons

    // JButton snooze = new JButton("Snooze");

   	JButton set = new JButton("Set Alarm");

   	JButton off = new JButton("Off");

     	   // snooze.setVisible(true);

       

    //Add Labels to panel

          

     	   

         main.add(datePanel);

         main.add(timePanel);

    main.add(alarmPanel);

    main.add(ipanel);

    bottom.add(set);

    //bottom.add(snooze);

    bottom.add(off);

     

     

 

     

    main.add(bottom);

    timePanel.add(cTime1);

    datePanel.add(cTime);

     

    //ipanel.add(input);

    ipanel.add(iHour);

    ipanel.add(iMinute);

    ipanel.add(iAMPM);

     

    alarmPanel.add(timeAlarm);

    alarmPanel.add(onoff);

    frame.add(main);

   

    frame.setPreferredSize(new Dimension(580, 350));

    frame.pack();

    frame.setLocationRelativeTo(null);

    frame.setVisible(true);

    frame.setResizable(true);



     

    //handle buttons

     

    set.addActionListener(new ActionListener()

{

public void actionPerformed(ActionEvent a)

{


    String text = iHour.getText();

    int hourInt = Integer.parseInt(text);

    alarm.setAlarmHour(hourInt);

    System.out.println(alarm.getalarmHour());


    String text1 = iMinute.getText();

    int minuteInt = Integer.parseInt(text1);

    alarm.setAlarmMinute(minuteInt);

    System.out.println(alarm.getAlarmMinute());


    String text2 = iAMPM.getText();

    int ampmInt = Integer.parseInt(text2);

    alarm.setAlarmAmPm(ampmInt);

    System.out.println(alarm.getAlarmAmPm());




    timeAlarm.setText(text + ":" + text1 + " " + text2 + " ");



	}

	});
   

    off.addActionListener(new ActionListener(){



    	@Override

	public void actionPerformed(ActionEvent e) {

	if(off.getModel().isPressed()){


	}
	System.exit(0);
	System.out.println("off");


	}

    });


    System.out.println(alarm.getalarmHour());


    double lastTime = System.currentTimeMillis();
    double currentTime = lastTime;
    double seconds = 45;
    double milliSeconds = 0;

     

    while(true){
    	currentTime = System.currentTimeMillis();
    	double deltaTime = currentTime - lastTime;
    	lastTime = currentTime;
	
    	//seconds += deltaTime / 1000.0;

    	milliSeconds += deltaTime;


    	if(milliSeconds >= 1000){


    		seconds +=1 ;

    		milliSeconds -= 1000;

    	}


    	if(seconds >= 60){

    		minute += 1;

    		seconds -= 60;

    	}

	String Time1 =  hour + ":" + minute + " " +  (int)seconds +  " " + getStringAMPM();

	cTime1.setText(Time1);

                //Play Alarm At Time

                if((hour == alarm.getalarmHour()) && (minute == alarm.getAlarmMinute()) && (amPm == alarm.getAlarmAmPm())){

                    //int number;

                URL url = new URL("http://www.wavsource.com/snds_2016-11-20_5768273412148964/sfx/ocean.wav");

                    File soundAlarm = new File("/Users/nosaedogun/Desktop/horn2.wav");

                    playRadioStream("http://radio.flex.ru:8000/radionami" );

                }


                timePanel.repaint();


	}

    }

    private static void playRadioStream(String spec) throws IOException, JavaLayerException {

// TODO Auto-generated method stub

    URLConnection urlConnection = new URL ( spec ).openConnection ();

        urlConnection.connect ();

        // Playing

        Player player = new Player ( urlConnection.getInputStream () );

        player.play ();


}

    
    public static String getStringAMPM(){

    	if(amPm == 0)

    		return "AM";

    	else

    		return "PM";

    }

	}
