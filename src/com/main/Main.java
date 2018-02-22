/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.floreantpos.IconFactory;
import com.floreantpos.config.TerminalConfig;
import com.floreantpos.main.Application;
import javax.swing.ImageIcon;
import com.printechs.Lic.License;
import com.printechs.Lic.LicenseActivationForm;
import java.util.Locale;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;

/**
 *
 * @author Thomas
 */
public class Main {

    private static final String DEVELOPMENT_MODE = "developmentMode";

    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon(IconFactory.class.getResource("/ui_icons/florent-pos.png"));
        SplashScreen splash = new SplashScreen(imageIcon);
        splash.setProgressMax(100);
        splash.setVisible(true);
        try {
            int count = 0;
            while (count <= 100) {
                Thread.sleep(100);
                count += 25;
                splash.setProgress("Checking License...", count);
                if (License.CheckLicense()) {
                    splash.setProgress("License validated.", 50);
                    Thread.sleep(2000);
                    splash.setProgress("Starting application...", 100);
                    Thread.sleep(2000);
                    Options options = new Options();
                    options.addOption(DEVELOPMENT_MODE, true, "State if this is developmentMode"); //$NON-NLS-1$
                    CommandLineParser parser = new BasicParser();
                    CommandLine commandLine = parser.parse(options, args);
                    String optionValue = commandLine.getOptionValue(DEVELOPMENT_MODE);
                    Locale defaultLocale = TerminalConfig.getDefaultLocale();
                    if (defaultLocale != null) {
                        Locale.setDefault(defaultLocale);
                    }
                    Application application = Application.getInstance();

                    if (optionValue != null) {
                        application.setDevelopmentMode(Boolean.valueOf(optionValue));
                    }
                    System.out.println("Starting application...");
                    application.start();
                    System.out.println("Application started.");
                    splash.setVisible(false);
                    break;
                } else {

                    LicenseActivationForm form=new LicenseActivationForm();
                    form.setVisible(true);
                    splash.setVisible(false);
                    break;
                    
                }
                
            }
        } catch (Exception ex) {
           System.out.println("Error "+ex.getMessage());
        }
        //System.exit(0);

        //splash.setVisible(false);
    }
}
