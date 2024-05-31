import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class ImageViewerGUI extends JFrame implements ActionListener {
    JButton selectFileButton;
    JButton showImageButton;
    JButton resizeButton;
    JButton showResizeButton;
    JButton grayscaleButton;
    JButton brightnessButton;
    JButton closeButton;
    JButton showBrightnessButton;
    JButton backButton;
    JTextField widthTextField;
    JTextField heightTextField;
    JTextField brightnessTextField;
    JLabel originalPictureLabel;
    JLabel changedPictureLabel;
    ImageIcon originalImage;
    ImageIcon changedImage;
    String filePath = "//home//payam//Pictures";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);
    int h = 900;
    int w = 1200;

    ImageViewerGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 300);
        this.setVisible(true);
        this.setResizable(true);

        mainPanel();
    }

    public void mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2));
        buttonsPanel.setBounds(50, 50, 350, 250);

        originalPictureLabel = new JLabel();
        originalPictureLabel.setBounds(70, 10, 900, 700);
        changedPictureLabel = new JLabel();
        changedPictureLabel.setBounds(70, 10, 900, 700);

        selectFileButton = new JButton("Choose Image");
        selectFileButton.setBackground(new Color(60, 102, 113));
        selectFileButton.setForeground(Color.WHITE);
        selectFileButton.setFont(new Font("Arial", Font.BOLD, 16));
        selectFileButton.addActionListener(this);

        showImageButton = new JButton("Show Image");
        showImageButton.setBackground(new Color(60, 102, 113));
        showImageButton.setForeground(Color.WHITE);
        showImageButton.setFont(new Font("Arial", Font.BOLD, 16));
        showImageButton.addActionListener(this);

        resizeButton = new JButton("Resize");
        resizeButton.setBackground(new Color(60, 102, 113));
        resizeButton.setForeground(Color.WHITE);
        resizeButton.setFont(new Font("Arial", Font.BOLD, 16));
        resizeButton.addActionListener(this);

        grayscaleButton = new JButton("Gray scale");
        grayscaleButton.setBackground(new Color(60, 102, 113));
        grayscaleButton.setForeground(Color.WHITE);
        grayscaleButton.setFont(new Font("Arial", Font.BOLD, 16));
        grayscaleButton.addActionListener(this);

        brightnessButton = new JButton("Brightness");
        brightnessButton.setBackground(new Color(60, 102, 113));
        brightnessButton.setForeground(Color.WHITE);
        brightnessButton.setFont(new Font("Arial", Font.BOLD, 16));
        brightnessButton.addActionListener(this);

        closeButton = new JButton("Exit");
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setBackground(new Color(60, 102, 113));
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(this);

        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.brightnessButton);
        buttonsPanel.add(this.grayscaleButton);
        buttonsPanel.add(this.resizeButton);
        buttonsPanel.add(this.closeButton);

        mainPanel.add(buttonsPanel);

        this.add(mainPanel);
    }

    public void resizePanel(){
        try {
            if (originalImage != null) {
                JPanel resizePanel = new JPanel();
                resizePanel.setLayout(null);

                this.getContentPane().removeAll();
                this.revalidate();
                this.repaint();

                JLabel resizeSectionLable = new JLabel("resize section");
                resizeSectionLable.setFont(new Font("Arial",Font.BOLD,17));
                resizeSectionLable.setBounds(860,40,300,60);
                resizePanel.add(resizeSectionLable);


                widthTextField = new JTextField();
                widthTextField.setBounds(860, 100, 130, 30);
                resizePanel.add(widthTextField);

                heightTextField = new JTextField();
                heightTextField.setBounds(860,130,130,30);
                resizePanel.add(heightTextField);

               JLabel widthLable = new JLabel("Width:");
               widthLable.setFont(new Font("Arial",Font.BOLD,15));
               widthLable.setBounds(790,80,350,60);
               resizePanel.add(widthLable);

                JLabel heightLable = new JLabel("Height:");
                heightLable.setFont(new Font("Arial",Font.BOLD,15));
                heightLable.setBounds(790,115,350,60);
                resizePanel.add(heightLable);

                showResizeButton = new JButton("Show Resault");
                showResizeButton.setBounds(930, 170, 150, 40);
                showResizeButton.setBackground(new Color(170, 120, 17));
                showResizeButton.setForeground(Color.WHITE);
                showResizeButton.setFont(new Font("Arial", Font.BOLD, 13));
                showResizeButton.addActionListener(this);
                resizePanel.add(showResizeButton);

                backButton = new JButton("Back");
                backButton.setBounds(720, 170, 150, 40);
                backButton.setBackground(new Color(170, 120, 17));
                backButton.setForeground(Color.WHITE);
                backButton.setFont(new Font("Arial", Font.BOLD, 13));
                backButton.addActionListener(this);
                resizePanel.add(backButton);


                this.add(resizePanel);
                this.revalidate();
                this.repaint();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void brightnessPanel() {
        try {
            if (originalImage != null) {
                JPanel brightnessPanel = new JPanel();
                brightnessPanel.setLayout(null);

                this.getContentPane().removeAll();
                this.revalidate();
                this.repaint();

                showBrightnessButton = new JButton("Result");
                showBrightnessButton.setBounds(370, 320, 100, 50);
                showBrightnessButton.setBackground(new Color(190, 120, 170));
                showBrightnessButton.setForeground(Color.WHITE);
                showBrightnessButton.setFont(new Font("Arial", Font.BOLD, 16));
                showBrightnessButton.addActionListener(this);

                backButton = new JButton("Back");
                backButton.setBounds(130, 320, 100, 50);
                backButton.setBackground(new Color(190, 120, 170));
                backButton.setForeground(Color.WHITE);
                backButton.setFont(new Font("Arial", Font.BOLD, 16));
                backButton.addActionListener(this);

                brightnessTextField = new JTextField();
                brightnessTextField.setBounds(250, 200, 120, 50);

                brightnessPanel.add(brightnessTextField);
                brightnessPanel.add(showBrightnessButton);
                brightnessPanel.add(backButton);

                this.add(brightnessPanel);
                this.revalidate();
                this.repaint();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void chooseFileImage() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showOpenDialog(ImageViewerGUI.this);
        if (option == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));

            originalImage = imageIcon;
            originalPictureLabel.setIcon(imageIcon);
        }
    }

    public void showOriginalImage() {
        try {
            if (originalImage != null) {
                JFrame tempFrame = new JFrame();
                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(null);
                originalPictureLabel.setBounds(420,-330 , 1600, 1300);
                originalPictureLabel.setIcon(originalImage);
                tempPanel.add(originalPictureLabel);

                this.revalidate();
                this.repaint();

                tempPanel.setSize(1800, 1000);
                tempFrame.setTitle("Image Viewer");
                tempFrame.setSize(1800, 1000);
                tempFrame.setVisible(true);
                tempFrame.setResizable(true);
                tempFrame.add(tempPanel);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void grayScaleImage(){
        try {
            if(originalImage != null) {
                JFrame tempFrame = new JFrame();
                JPanel tempPanel = new JPanel();

                int width = toBufferedImage(originalImage.getImage()).getWidth();
                int height = toBufferedImage(originalImage.getImage()).getHeight();
                BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

                Graphics2D g = grayscaleImage.createGraphics();
                g.drawImage(toBufferedImage(originalImage.getImage()), 0, 0, null);
                g.dispose();

                ImageIcon changedImageIcon = new ImageIcon(grayscaleImage);

                tempPanel.setLayout(null);
                changedPictureLabel.setBounds(420,-330 , 1600, 1300);
                changedPictureLabel.setIcon(changedImageIcon);
                tempPanel.add(changedPictureLabel);




                tempPanel.setSize(1800, 1000);
                tempFrame.setTitle("Image Viewer");
                tempFrame.setSize(1800, 1000);
                tempFrame.setVisible(true);
                tempFrame.setResizable(true);
                tempFrame.add(tempPanel);
            }
        }
        catch (NullPointerException e){}

    }


    public void showResizeImage(int w, int h){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        int targetWidth = Integer.parseInt(widthTextField.getText());
        int targetHeight = Integer.parseInt(heightTextField.getText());

        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(originalImage.getImage(), 0, 0, targetWidth, targetHeight, null);
        g.dispose();

        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        changedPictureLabel.setIcon(resizedIcon);
        tempPanel.add(changedPictureLabel);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);
    }

        //this method and the toBufferedImage method is for changing brightness of the image.
    public void showBrightnessImage() {
        try {
            float brightnessFactor = Float.parseFloat(brightnessTextField.getText());
            BufferedImage bufferedImage = toBufferedImage(originalImage.getImage());
            RescaleOp rescaleOp = new RescaleOp(brightnessFactor, 0, null);
            BufferedImage brighterImage = rescaleOp.filter(bufferedImage, null);

            changedPictureLabel.setIcon(new ImageIcon(brighterImage));

            JFrame tempFrame = new JFrame();
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(null);
            changedPictureLabel.setBounds(420,-330 , 1600, 1300);
            tempPanel.add(changedPictureLabel);

            tempPanel.setSize(1800, 1000);
            tempFrame.setTitle("Image Viewer");
            tempFrame.setSize(1800, 1000);
            tempFrame.setVisible(true);
            tempFrame.setResizable(true);
            tempFrame.add(tempPanel);

            this.revalidate();
            this.repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid brightness value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static BufferedImage toBufferedImage(Image img) {
    if (img instanceof BufferedImage) {
        return (BufferedImage) img;
    }
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();
    return bimage;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resizeButton) {
           resizePanel();
        } else if (e.getSource() == showImageButton) {
            showOriginalImage();
        } else if (e.getSource() == grayscaleButton) {
            grayScaleImage();
        } else if(e.getSource() == showResizeButton) {
            showResizeImage(w,h);
        } else if (e.getSource() == brightnessButton) {
            brightnessPanel();
        } else if (e.getSource() == showBrightnessButton) {
            showBrightnessImage();
        } else if (e.getSource() == selectFileButton) {
            chooseFileImage();
        } else if (e.getSource() == closeButton) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } else if (e.getSource() == backButton) {
            this.getContentPane().removeAll();
            this.mainPanel();
            this.repaint();
            this.revalidate();
        }
    }
}
