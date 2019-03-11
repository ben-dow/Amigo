package AmigoConfig.Components;

import AmigoConfig.AmigoDevice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ColorBacklightButtonTest {

    AmigoDevice device;

    ArrayList<ColorBacklightButton> btns = new ArrayList<ColorBacklightButton>();

    @BeforeEach
    public void init(){

        try {
            MidiDevice.Info[] infos  = AmigoDevice.CollectDevices();
            device = new AmigoDevice(infos[3], infos[2]);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        for(int i = 0; i <= 63; i++){

            ColorBacklightButton btn = new ColorBacklightButton(device,i);
            btns.add(btn);

        }





    }


    @Test
    void TurnOn(){

        for(ColorBacklightButton btn: btns){
            btn.BackLightOn();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void TurnOff(){

        for(ColorBacklightButton btn: btns){
            btn.BackLightOff();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    void Flash(){
        for(ColorBacklightButton btn: btns){
            btn.BackLightFlash();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void Green(){
        for(ColorBacklightButton btn: btns){
            btn.Green();
            btn.BackLightOn();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void Red(){
        for(ColorBacklightButton btn: btns){
            btn.Red();
            btn.BackLightOn();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void Yellow(){
        for(ColorBacklightButton btn: btns){
            btn.Yellow();
            btn.BackLightOn();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void ToggleOn(){

        for(ColorBacklightButton btn: btns){
            btn.BackLightOff();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(ColorBacklightButton btn: btns){
            btn.BackLightToggle();
        }




        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void ToggleOff(){

        for(ColorBacklightButton btn: btns){
            btn.BackLightOn();
        }


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for(ColorBacklightButton btn: btns){
            btn.BackLightToggle();
        }




        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}