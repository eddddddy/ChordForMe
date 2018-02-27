import os
import matplotlib.pyplot as plt
from scipy import signal
from scipy.io import wavfile

#directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "dominant_seventh_root\\"]
directories_list = ["minor_first_inversion\\", "minor_second_inversion\\"]

for directory in directories_list:
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
            plt.savefig("images\\" + file[:-4] + "_" + str(i) + ".png", bbox_inches="tight", pad_inches=0)
