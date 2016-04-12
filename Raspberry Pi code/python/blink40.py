import RPi.GPIO as GPIO
import time
import sys 


def blink(pin,status):
    GPIO.output(pin,status)
    time.sleep(1)
    return

liste =[7,11,13,15]
#pin=liste[int(sys.argv[1])-1]
#status=int(sys.argv[2])
pin=15
status=0
GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)  
GPIO.cleanup(pin)
GPIO.setup(pin,GPIO.OUT)
blink(pin,status)
