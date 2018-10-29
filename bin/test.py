from gtts import gTTS 
from playsound import playsound
import os,sys
print(sys.argv[1])
mytext = 'Hey'+sys.argv[1]+', I am Atom! How can I help You?'
language = 'en'
myobj = gTTS(text=mytext, lang=language, slow=False) 
myobj.save("./src/welcome.mp3") 
playsound('./src/welcome.mp3')
