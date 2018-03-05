import os
import matplotlib.pyplot as plt
from scipy import signal
from scipy.io import wavfile

<<<<<<< HEAD
<<<<<<< HEAD
fileroot1 = "C:\\Users\\James Jiang\\Documents\\ChordForMe\\"
fileroot2 = "C:\\Users\\Edward\\Documents\\Side Projects\\ChordForMe\\"

# original code: 
'''

directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "dominant_seventh_root\\"]
=======
#directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "minor_first_inversion\\", "minor_second_inversion\\", "dominant_seventh_root\\"]
directories_list = ["dominant_seventh_first_inversion\\", "dominant_seventh_second_inversion\\", "dominant_seventh_third_inversion\\"]
>>>>>>> 8f5d50b67b2dddc9d7752a9fdb97b8f0c65a32ff
=======
#directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "minor_first_inversion\\", "minor_second_inversion\\", "dominant_seventh_root\\"]
directories_list = ["dominant_seventh_first_inversion\\", "dominant_seventh_second_inversion\\", "dominant_seventh_third_inversion\\"]
>>>>>>> 8f5d50b67b2dddc9d7752a9fdb97b8f0c65a32ff

for directory in directories_list:
    print(directory)
    audio_files = os.listdir("chordrecordings\\" + directory)
    for file in audio_files:
        sample_rate, samples = wavfile.read("chordrecordings\\" + directory + file)
        frequencies, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)
        plt.pcolormesh(times, frequencies, spectrogram)
        for i in range(16):
            plt.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
            plt.axis("off")
            ax = plt.gca()
            ax.get_xaxis().set_visible(False)
            ax.get_yaxis().set_visible(False)
<<<<<<< HEAD
<<<<<<< HEAD
            plt.savefig("C:\\Users\\James Jiang\\Documents\\ChordForMe\\nn\\images\\" + file[:-4] + "_" + str(i) + ".png", bbox_inches="tight", pad_inches=0)

'''

def genimage():
	audiopath = fileroot2 + "chordrecordings\\major_root\\a_major_a_fourth_octave.wav"
	sample_rate, samples = wavfile.read(audiopath)
	print(samples)
	'''
    frequencies, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)
    plt.pcolormesh(times, frequencies, spectrogram)
    for i in range(16):
        plt.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
        plt.axis("off")
        ax = plt.gca()
        ax.get_xaxis().set_visible(False)
        ax.get_yaxis().set_visible(False)
        plt.savefig(imagepath, bbox_inches="tight", pad_inches=0)
	'''
		

		
if __name__ == "__main__":
	print(genimage())
	
=======
            plt.savefig("images\\" + file[:-4] + "_" + str(i) + ".png", bbox_inches="tight", pad_inches=0)
>>>>>>> 8f5d50b67b2dddc9d7752a9fdb97b8f0c65a32ff
=======
            plt.savefig("images\\" + file[:-4] + "_" + str(i) + ".png", bbox_inches="tight", pad_inches=0)
>>>>>>> 8f5d50b67b2dddc9d7752a9fdb97b8f0c65a32ff
