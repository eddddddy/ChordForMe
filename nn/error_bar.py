import matplotlib
import matplotlib.pyplot as plt
import numpy as np
import audio_to_chord

major_root = [
    "d_flat_major_d_flat_first_octave",
    "d_major_d_first_octave",
    "e_flat_major_e_flat_first_octave",
    "e_major_e_first_octave",
    "f_major_f_first_octave",
    "f_sharp_major_f_sharp_first_octave",
    "g_major_g_first_octave",
    "a_flat_major_a_flat_first_octave",
    "a_major_a_first_octave",
    "b_flat_major_b_flat_first_octave",
    "b_major_b_first_octave",
    "c_major_c_first_octave",
    "d_flat_major_d_flat_second_octave",
    "d_major_d_second_octave",
    "e_flat_major_e_flat_second_octave",
    "e_major_e_second_octave",
    "f_major_f_second_octave",
    "f_sharp_major_f_sharp_second_octave",
    "g_major_g_second_octave",
    "a_flat_major_a_flat_second_octave",
    "a_major_a_second_octave",
    "b_flat_major_b_flat_second_octave",
    "b_major_b_second_octave",
    "c_major_c_second_octave",
    "d_flat_major_d_flat_third_octave",
    "d_major_d_third_octave",
    "e_flat_major_e_flat_third_octave",
    "e_major_e_third_octave",
    "f_major_f_third_octave",
    "f_sharp_major_f_sharp_third_octave",
    "g_major_g_third_octave",
    "a_flat_major_a_flat_third_octave",
    "a_major_a_third_octave",
    "b_flat_major_b_flat_third_octave",
    "b_major_b_third_octave",
    "c_major_c_third_octave",
    "d_flat_major_d_flat_fourth_octave",
    "d_major_d_fourth_octave",
    "e_flat_major_e_flat_fourth_octave",
    "e_major_e_fourth_octave",
    "f_major_f_fourth_octave",
    "f_sharp_major_f_sharp_fourth_octave",
    "g_major_g_fourth_octave",
    "a_flat_major_a_flat_fourth_octave",
    "a_major_a_fourth_octave",
    "b_flat_major_b_flat_fourth_octave",
    "b_major_b_fourth_octave",
    "c_major_c_fourth_octave",
    "d_flat_major_d_flat_fifth_octave",
    "d_major_d_fifth_octave",
    "e_flat_major_e_flat_fifth_octave",
    "e_major_e_fifth_octave",
    "f_major_f_fifth_octave",
    "f_sharp_major_f_sharp_fifth_octave",
    "g_major_g_fifth_octave",
    "a_flat_major_a_flat_fifth_octave",
    "a_major_a_fifth_octave",
    "b_flat_major_b_flat_fifth_octave",
    "b_major_b_fifth_octave",
    "c_major_c_fifth_octave",
    "d_flat_major_d_flat_sixth_octave",
    "d_major_d_sixth_octave",
    "e_flat_major_e_flat_sixth_octave",
    "e_major_e_sixth_octave",
    "f_major_f_sixth_octave",
    "f_sharp_major_f_sharp_sixth_octave",
    "g_major_g_sixth_octave",
    "a_flat_major_a_flat_sixth_octave",
    "a_major_a_sixth_octave",
    "b_flat_major_b_flat_sixth_octave",
    "b_major_b_sixth_octave",
    "c_major_c_sixth_octave",
    "d_flat_major_d_flat_seventh_octave",
    "d_major_d_seventh_octave"]

major_first_inversion = [
    "a_major_d_flat_first_octave",
    "b_flat_major_d_first_octave",
    "b_major_e_flat_first_octave",
    "c_major_e_first_octave",
    "d_flat_major_f_first_octave",
    "d_major_f_sharp_first_octave",
    "e_flat_major_g_first_octave",
    "e_major_a_flat_first_octave",
    "f_major_a_first_octave",
    "f_sharp_major_b_flat_first_octave",
    "g_major_b_first_octave",
    "a_flat_major_c_first_octave",
    "a_major_d_flat_second_octave",
    "b_flat_major_d_second_octave",
    "b_major_e_flat_second_octave",
    "c_major_e_second_octave",
    "d_flat_major_f_second_octave",
    "d_major_f_sharp_second_octave",
    "e_flat_major_g_second_octave",
    "e_major_a_flat_second_octave",
    "f_major_a_second_octave",
    "f_sharp_major_b_flat_second_octave",
    "g_major_b_second_octave",
    "a_flat_major_c_second_octave",
    "a_major_d_flat_third_octave",
    "b_flat_major_d_third_octave",
    "b_major_e_flat_third_octave",
    "c_major_e_third_octave",
    "d_flat_major_f_third_octave",
    "d_major_f_sharp_third_octave",
    "e_flat_major_g_third_octave",
    "e_major_a_flat_third_octave",
    "f_major_a_third_octave",
    "f_sharp_major_b_flat_third_octave",
    "g_major_b_third_octave",
    "a_flat_major_c_third_octave",
    "a_major_d_flat_fourth_octave",
    "b_flat_major_d_fourth_octave",
    "b_major_e_flat_fourth_octave",
    "c_major_e_fourth_octave",
    "d_flat_major_f_fourth_octave",
    "d_major_f_sharp_fourth_octave",
    "e_flat_major_g_fourth_octave",
    "e_major_a_flat_fourth_octave",
    "f_major_a_fourth_octave",
    "f_sharp_major_b_flat_fourth_octave",
    "g_major_b_fourth_octave",
    "a_flat_major_c_fourth_octave",
    "a_major_d_flat_fifth_octave",
    "b_flat_major_d_fifth_octave",
    "b_major_e_flat_fifth_octave",
    "c_major_e_fifth_octave",
    "d_flat_major_f_fifth_octave",
    "d_major_f_sharp_fifth_octave",
    "e_flat_major_g_fifth_octave",
    "e_major_a_flat_fifth_octave",
    "f_major_a_fifth_octave",
    "f_sharp_major_b_flat_fifth_octave",
    "g_major_b_fifth_octave",
    "a_flat_major_c_fifth_octave",
    "a_major_d_flat_sixth_octave",
    "b_flat_major_d_sixth_octave",
    "b_major_e_flat_sixth_octave",
    "c_major_e_sixth_octave",
    "d_flat_major_f_sixth_octave",
    "d_major_f_sharp_sixth_octave",
    "e_flat_major_g_sixth_octave",
    "e_major_a_flat_sixth_octave",
    "f_major_a_sixth_octave",
    "f_sharp_major_b_flat_sixth_octave",
    "g_major_b_sixth_octave",
    "a_flat_major_c_sixth_octave",
    "a_major_d_flat_seventh_octave"]

major_second_inversion = [
    "f_sharp_major_d_flat_first_octave",
    "g_major_d_first_octave",
    "a_flat_major_e_flat_first_octave",
    "a_major_e_first_octave",
    "b_flat_major_f_first_octave",
    "b_major_f_sharp_first_octave",
    "c_major_g_first_octave",
    "d_flat_major_a_flat_first_octave",
    "d_major_a_first_octave",
    "e_flat_major_b_flat_first_octave",
    "e_major_b_first_octave",
    "f_major_c_first_octave",
    "f_sharp_major_d_flat_second_octave",
    "g_major_d_second_octave",
    "a_flat_major_e_flat_second_octave",
    "a_major_e_second_octave",
    "b_flat_major_f_second_octave",
    "b_major_f_sharp_second_octave",
    "c_major_g_second_octave",
    "d_flat_major_a_flat_second_octave",
    "d_major_a_second_octave",
    "e_flat_major_b_flat_second_octave",
    "e_major_b_second_octave",
    "f_major_c_second_octave",
    "f_sharp_major_d_flat_third_octave",
    "g_major_d_third_octave",
    "a_flat_major_e_flat_third_octave",
    "a_major_e_third_octave",
    "b_flat_major_f_third_octave",
    "b_major_f_sharp_third_octave",
    "c_major_g_third_octave",
    "d_flat_major_a_flat_third_octave",
    "d_major_a_third_octave",
    "e_flat_major_b_flat_third_octave",
    "e_major_b_third_octave",
    "f_major_c_third_octave",
    "f_sharp_major_d_flat_fourth_octave",
    "g_major_d_fourth_octave",
    "a_flat_major_e_flat_fourth_octave",
    "a_major_e_fourth_octave",
    "b_flat_major_f_fourth_octave",
    "b_major_f_sharp_fourth_octave",
    "c_major_g_fourth_octave",
    "d_flat_major_a_flat_fourth_octave",
    "d_major_a_fourth_octave",
    "e_flat_major_b_flat_fourth_octave",
    "e_major_b_fourth_octave",
    "f_major_c_fourth_octave",
    "f_sharp_major_d_flat_fifth_octave",
    "g_major_d_fifth_octave",
    "a_flat_major_e_flat_fifth_octave",
    "a_major_e_fifth_octave",
    "b_flat_major_f_fifth_octave",
    "b_major_f_sharp_fifth_octave",
    "c_major_g_fifth_octave",
    "d_flat_major_a_flat_fifth_octave",
    "d_major_a_fifth_octave",
    "e_flat_major_b_flat_fifth_octave",
    "e_major_b_fifth_octave",
    "f_major_c_fifth_octave",
    "f_sharp_major_d_flat_sixth_octave",
    "g_major_d_sixth_octave",
    "a_flat_major_e_flat_sixth_octave",
    "a_major_e_sixth_octave",
    "b_flat_major_f_sixth_octave",
    "b_major_f_sharp_sixth_octave",
    "c_major_g_sixth_octave",
    "d_flat_major_a_flat_sixth_octave",
    "d_major_a_sixth_octave",
    "e_flat_major_b_flat_sixth_octave",
    "e_major_b_sixth_octave",
    "f_major_c_sixth_octave"]

minor_root = [
    "d_flat_minor_d_flat_first_octave",
    "d_minor_d_first_octave",
    "e_flat_minor_e_flat_first_octave",
    "e_minor_e_first_octave",
    "f_minor_f_first_octave",
    "f_sharp_minor_f_sharp_first_octave",
    "g_minor_g_first_octave",
    "a_flat_minor_a_flat_first_octave",
    "a_minor_a_first_octave",
    "b_flat_minor_b_flat_first_octave",
    "b_minor_b_first_octave",
    "c_minor_c_first_octave",
    "d_flat_minor_d_flat_second_octave",
    "d_minor_d_second_octave",
    "e_flat_minor_e_flat_second_octave",
    "e_minor_e_second_octave",
    "f_minor_f_second_octave",
    "f_sharp_minor_f_sharp_second_octave",
    "g_minor_g_second_octave",
    "a_flat_minor_a_flat_second_octave",
    "a_minor_a_second_octave",
    "b_flat_minor_b_flat_second_octave",
    "b_minor_b_second_octave",
    "c_minor_c_second_octave",
    "d_flat_minor_d_flat_third_octave",
    "d_minor_d_third_octave",
    "e_flat_minor_e_flat_third_octave",
    "e_minor_e_third_octave",
    "f_minor_f_third_octave",
    "f_sharp_minor_f_sharp_third_octave",
    "g_minor_g_third_octave",
    "a_flat_minor_a_flat_third_octave",
    "a_minor_a_third_octave",
    "b_flat_minor_b_flat_third_octave",
    "b_minor_b_third_octave",
    "c_minor_c_third_octave",
    "d_flat_minor_d_flat_fourth_octave",
    "d_minor_d_fourth_octave",
    "e_flat_minor_e_flat_fourth_octave",
    "e_minor_e_fourth_octave",
    "f_minor_f_fourth_octave",
    "f_sharp_minor_f_sharp_fourth_octave",
    "g_minor_g_fourth_octave",
    "a_flat_minor_a_flat_fourth_octave",
    "a_minor_a_fourth_octave",
    "b_flat_minor_b_flat_fourth_octave",
    "b_minor_b_fourth_octave",
    "c_minor_c_fourth_octave",
    "d_flat_minor_d_flat_fifth_octave",
    "d_minor_d_fifth_octave",
    "e_flat_minor_e_flat_fifth_octave",
    "e_minor_e_fifth_octave",
    "f_minor_f_fifth_octave",
    "f_sharp_minor_f_sharp_fifth_octave",
    "g_minor_g_fifth_octave",
    "a_flat_minor_a_flat_fifth_octave",
    "a_minor_a_fifth_octave",
    "b_flat_minor_b_flat_fifth_octave",
    "b_minor_b_fifth_octave",
    "c_minor_c_fifth_octave",
    "d_flat_minor_d_flat_sixth_octave",
    "d_minor_d_sixth_octave",
    "e_flat_minor_e_flat_sixth_octave",
    "e_minor_e_sixth_octave",
    "f_minor_f_sixth_octave",
    "f_sharp_minor_f_sharp_sixth_octave",
    "g_minor_g_sixth_octave",
    "a_flat_minor_a_flat_sixth_octave",
    "a_minor_a_sixth_octave",
    "b_flat_minor_b_flat_sixth_octave",
    "b_minor_b_sixth_octave",
    "c_minor_c_sixth_octave",
    "d_flat_minor_d_flat_seventh_octave",
    "d_minor_d_seventh_octave"]

minor_first_inversion = [
    "b_flat_minor_d_flat_first_octave",
    "b_minor_d_first_octave",
    "c_minor_e_flat_first_octave",
    "d_flat_minor_e_first_octave",
    "d_minor_f_first_octave",
    "e_flat_minor_f_sharp_first_octave",
    "e_minor_g_first_octave",
    "f_minor_a_flat_first_octave",
    "f_sharp_minor_a_first_octave",
    "g_minor_b_flat_first_octave",
    "a_flat_minor_b_first_octave",
    "a_minor_c_first_octave",
    "b_flat_minor_d_flat_second_octave",
    "b_minor_d_second_octave",
    "c_minor_e_flat_second_octave",
    "d_flat_minor_e_second_octave",
    "d_minor_f_second_octave",
    "e_flat_minor_f_sharp_second_octave",
    "e_minor_g_second_octave",
    "f_minor_a_flat_second_octave",
    "f_sharp_minor_a_second_octave",
    "g_minor_b_flat_second_octave",
    "a_flat_minor_b_second_octave",
    "a_minor_c_second_octave",
    "b_flat_minor_d_flat_third_octave",
    "b_minor_d_third_octave",
    "c_minor_e_flat_third_octave",
    "d_flat_minor_e_third_octave",
    "d_minor_f_third_octave",
    "e_flat_minor_f_sharp_third_octave",
    "e_minor_g_third_octave",
    "f_minor_a_flat_third_octave",
    "f_sharp_minor_a_third_octave",
    "g_minor_b_flat_third_octave",
    "a_flat_minor_b_third_octave",
    "a_minor_c_third_octave",
    "b_flat_minor_d_flat_fourth_octave",
    "b_minor_d_fourth_octave",
    "c_minor_e_flat_fourth_octave",
    "d_flat_minor_e_fourth_octave",
    "d_minor_f_fourth_octave",
    "e_flat_minor_f_sharp_fourth_octave",
    "e_minor_g_fourth_octave",
    "f_minor_a_flat_fourth_octave",
    "f_sharp_minor_a_fourth_octave",
    "g_minor_b_flat_fourth_octave",
    "a_flat_minor_b_fourth_octave",
    "a_minor_c_fourth_octave",
    "b_flat_minor_d_flat_fifth_octave",
    "b_minor_d_fifth_octave",
    "c_minor_e_flat_fifth_octave",
    "d_flat_minor_e_fifth_octave",
    "d_minor_f_fifth_octave",
    "e_flat_minor_f_sharp_fifth_octave",
    "e_minor_g_fifth_octave",
    "f_minor_a_flat_fifth_octave",
    "f_sharp_minor_a_fifth_octave",
    "g_minor_b_flat_fifth_octave",
    "a_flat_minor_b_fifth_octave",
    "a_minor_c_fifth_octave",
    "b_flat_minor_d_flat_sixth_octave",
    "b_minor_d_sixth_octave",
    "c_minor_e_flat_sixth_octave",
    "d_flat_minor_e_sixth_octave",
    "d_minor_f_sixth_octave",
    "e_flat_minor_f_sharp_sixth_octave",
    "e_minor_g_sixth_octave",
    "f_minor_a_flat_sixth_octave",
    "f_sharp_minor_a_sixth_octave",
    "g_minor_b_flat_sixth_octave",
    "a_flat_minor_b_sixth_octave",
    "a_minor_c_sixth_octave"]

minor_second_inversion = [
    "f_sharp_minor_d_flat_first_octave",
    "g_minor_d_first_octave",
    "a_flat_minor_e_flat_first_octave",
    "a_minor_e_first_octave",
    "b_flat_minor_f_first_octave",
    "b_minor_f_sharp_first_octave",
    "c_minor_g_first_octave",
    "d_flat_minor_a_flat_first_octave",
    "d_minor_a_first_octave",
    "e_flat_minor_b_flat_first_octave",
    "e_minor_b_first_octave",
    "f_minor_c_first_octave",
    "f_sharp_minor_d_flat_second_octave",
    "g_minor_d_second_octave",
    "a_flat_minor_e_flat_second_octave",
    "a_minor_e_second_octave",
    "b_flat_minor_f_second_octave",
    "b_minor_f_sharp_second_octave",
    "c_minor_g_second_octave",
    "d_flat_minor_a_flat_second_octave",
    "d_minor_a_second_octave",
    "e_flat_minor_b_flat_second_octave",
    "e_minor_b_second_octave",
    "f_minor_c_second_octave",
    "f_sharp_minor_d_flat_third_octave",
    "g_minor_d_third_octave",
    "a_flat_minor_e_flat_third_octave",
    "a_minor_e_third_octave",
    "b_flat_minor_f_third_octave",
    "b_minor_f_sharp_third_octave",
    "c_minor_g_third_octave",
    "d_flat_minor_a_flat_third_octave",
    "d_minor_a_third_octave",
    "e_flat_minor_b_flat_third_octave",
    "e_minor_b_third_octave",
    "f_minor_c_third_octave",
    "f_sharp_minor_d_flat_fourth_octave",
    "g_minor_d_fourth_octave",
    "a_flat_minor_e_flat_fourth_octave",
    "a_minor_e_fourth_octave",
    "b_flat_minor_f_fourth_octave",
    "b_minor_f_sharp_fourth_octave",
    "c_minor_g_fourth_octave",
    "d_flat_minor_a_flat_fourth_octave",
    "d_minor_a_fourth_octave",
    "e_flat_minor_b_flat_fourth_octave",
    "e_minor_b_fourth_octave",
    "f_minor_c_fourth_octave",
    "f_sharp_minor_d_flat_fifth_octave",
    "g_minor_d_fifth_octave",
    "a_flat_minor_e_flat_fifth_octave",
    "a_minor_e_fifth_octave",
    "b_flat_minor_f_fifth_octave",
    "b_minor_f_sharp_fifth_octave",
    "c_minor_g_fifth_octave",
    "d_flat_minor_a_flat_fifth_octave",
    "d_minor_a_fifth_octave",
    "e_flat_minor_b_flat_fifth_octave",
    "e_minor_b_fifth_octave",
    "f_minor_c_fifth_octave",
    "f_sharp_minor_d_flat_sixth_octave",
    "g_minor_d_sixth_octave",
    "a_flat_minor_e_flat_sixth_octave",
    "a_minor_e_sixth_octave",
    "b_flat_minor_f_sixth_octave",
    "b_minor_f_sharp_sixth_octave",
    "c_minor_g_sixth_octave",
    "d_flat_minor_a_flat_sixth_octave",
    "d_minor_a_sixth_octave",
    "e_flat_minor_b_flat_sixth_octave",
    "e_minor_b_sixth_octave",
    "f_minor_c_sixth_octave",
    "f_sharp_minor_d_flat_seventh_octave"]

dominant_seventh_root = [
    "d_flat_dominant_seventh_d_flat_first_octave",
    "d_dominant_seventh_d_first_octave",
    "e_flat_dominant_seventh_e_flat_first_octave",
    "e_dominant_seventh_e_first_octave",
    "f_dominant_seventh_f_first_octave",
    "f_sharp_dominant_seventh_f_sharp_first_octave",
    "g_dominant_seventh_g_first_octave",
    "a_flat_dominant_seventh_a_flat_first_octave",
    "a_dominant_seventh_a_first_octave",
    "b_flat_dominant_seventh_b_flat_first_octave",
    "b_dominant_seventh_b_first_octave",
    "c_dominant_seventh_c_first_octave",
    "d_flat_dominant_seventh_d_flat_second_octave",
    "d_dominant_seventh_d_second_octave",
    "e_flat_dominant_seventh_e_flat_second_octave",
    "e_dominant_seventh_e_second_octave",
    "f_dominant_seventh_f_second_octave",
    "f_sharp_dominant_seventh_f_sharp_second_octave",
    "g_dominant_seventh_g_second_octave",
    "a_flat_dominant_seventh_a_flat_second_octave",
    "a_dominant_seventh_a_second_octave",
    "b_flat_dominant_seventh_b_flat_second_octave",
    "b_dominant_seventh_b_second_octave",
    "c_dominant_seventh_c_second_octave",
    "d_flat_dominant_seventh_d_flat_third_octave",
    "d_dominant_seventh_d_third_octave",
    "e_flat_dominant_seventh_e_flat_third_octave",
    "e_dominant_seventh_e_third_octave",
    "f_dominant_seventh_f_third_octave",
    "f_sharp_dominant_seventh_f_sharp_third_octave",
    "g_dominant_seventh_g_third_octave",
    "a_flat_dominant_seventh_a_flat_third_octave",
    "a_dominant_seventh_a_third_octave",
    "b_flat_dominant_seventh_b_flat_third_octave",
    "b_dominant_seventh_b_third_octave",
    "c_dominant_seventh_c_third_octave",
    "d_flat_dominant_seventh_d_flat_fourth_octave",
    "d_dominant_seventh_d_fourth_octave",
    "e_flat_dominant_seventh_e_flat_fourth_octave",
    "e_dominant_seventh_e_fourth_octave",
    "f_dominant_seventh_f_fourth_octave",
    "f_sharp_dominant_seventh_f_sharp_fourth_octave",
    "g_dominant_seventh_g_fourth_octave",
    "a_flat_dominant_seventh_a_flat_fourth_octave",
    "a_dominant_seventh_a_fourth_octave",
    "b_flat_dominant_seventh_b_flat_fourth_octave",
    "b_dominant_seventh_b_fourth_octave",
    "c_dominant_seventh_c_fourth_octave",
    "d_flat_dominant_seventh_d_flat_fifth_octave",
    "d_dominant_seventh_d_fifth_octave",
    "e_flat_dominant_seventh_e_flat_fifth_octave",
    "e_dominant_seventh_e_fifth_octave",
    "f_dominant_seventh_f_fifth_octave",
    "f_sharp_dominant_seventh_f_sharp_fifth_octave",
    "g_dominant_seventh_g_fifth_octave",
    "a_flat_dominant_seventh_a_flat_fifth_octave",
    "a_dominant_seventh_a_fifth_octave",
    "b_flat_dominant_seventh_b_flat_fifth_octave",
    "b_dominant_seventh_b_fifth_octave",
    "c_dominant_seventh_c_fifth_octave",
    "d_flat_dominant_seventh_d_flat_sixth_octave",
    "d_dominant_seventh_d_sixth_octave",
    "e_flat_dominant_seventh_e_flat_sixth_octave",
    "e_dominant_seventh_e_sixth_octave",
    "f_dominant_seventh_f_sixth_octave",
    "f_sharp_dominant_seventh_f_sharp_sixth_octave",
    "g_dominant_seventh_g_sixth_octave",
    "a_flat_dominant_seventh_a_flat_sixth_octave",
    "a_dominant_seventh_a_sixth_octave",
    "b_flat_dominant_seventh_b_flat_sixth_octave",
    "b_dominant_seventh_b_sixth_octave"]

dominant_seventh_first_inversion = [
    "a_dominant_seventh_d_flat_first_octave",
    "b_flat_dominant_seventh_d_first_octave",
    "b_dominant_seventh_e_flat_first_octave",
    "c_dominant_seventh_e_first_octave",
    "d_flat_dominant_seventh_f_first_octave",
    "d_dominant_seventh_f_sharp_first_octave",
    "e_flat_dominant_seventh_g_first_octave",
    "e_dominant_seventh_a_flat_first_octave",
    "f_dominant_seventh_a_first_octave",
    "f_sharp_dominant_seventh_b_flat_first_octave",
    "g_dominant_seventh_b_first_octave",
    "a_flat_dominant_seventh_c_first_octave",
    "a_dominant_seventh_d_flat_second_octave",
    "b_flat_dominant_seventh_d_second_octave",
    "b_dominant_seventh_e_flat_second_octave",
    "c_dominant_seventh_e_second_octave",
    "d_flat_dominant_seventh_f_second_octave",
    "d_dominant_seventh_f_sharp_second_octave",
    "e_flat_dominant_seventh_g_second_octave",
    "e_dominant_seventh_a_flat_second_octave",
    "f_dominant_seventh_a_second_octave",
    "f_sharp_dominant_seventh_b_flat_second_octave",
    "g_dominant_seventh_b_second_octave",
    "a_flat_dominant_seventh_c_second_octave",
    "a_dominant_seventh_d_flat_third_octave",
    "b_flat_dominant_seventh_d_third_octave",
    "b_dominant_seventh_e_flat_third_octave",
    "c_dominant_seventh_e_third_octave",
    "d_flat_dominant_seventh_f_third_octave",
    "d_dominant_seventh_f_sharp_third_octave",
    "e_flat_dominant_seventh_g_third_octave",
    "e_dominant_seventh_a_flat_third_octave",
    "f_dominant_seventh_a_third_octave",
    "f_sharp_dominant_seventh_b_flat_third_octave",
    "g_dominant_seventh_b_third_octave",
    "a_flat_dominant_seventh_c_third_octave",
    "a_dominant_seventh_d_flat_fourth_octave",
    "b_flat_dominant_seventh_d_fourth_octave",
    "b_dominant_seventh_e_flat_fourth_octave",
    "c_dominant_seventh_e_fourth_octave",
    "d_flat_dominant_seventh_f_fourth_octave",
    "d_dominant_seventh_f_sharp_fourth_octave",
    "e_flat_dominant_seventh_g_fourth_octave",
    "e_dominant_seventh_a_flat_fourth_octave",
    "f_dominant_seventh_a_fourth_octave",
    "f_sharp_dominant_seventh_b_flat_fourth_octave",
    "g_dominant_seventh_b_fourth_octave",
    "a_flat_dominant_seventh_c_fourth_octave",
    "a_dominant_seventh_d_flat_fifth_octave",
    "b_flat_dominant_seventh_d_fifth_octave",
    "b_dominant_seventh_e_flat_fifth_octave",
    "c_dominant_seventh_e_fifth_octave",
    "d_flat_dominant_seventh_f_fifth_octave",
    "d_dominant_seventh_f_sharp_fifth_octave",
    "e_flat_dominant_seventh_g_fifth_octave",
    "e_dominant_seventh_a_flat_fifth_octave",
    "f_dominant_seventh_a_fifth_octave",
    "f_sharp_dominant_seventh_b_flat_fifth_octave",
    "g_dominant_seventh_b_fifth_octave",
    "a_flat_dominant_seventh_c_fifth_octave",
    "a_dominant_seventh_d_flat_sixth_octave",
    "b_flat_dominant_seventh_d_sixth_octave",
    "b_dominant_seventh_e_flat_sixth_octave",
    "c_dominant_seventh_e_sixth_octave",
    "d_flat_dominant_seventh_f_sixth_octave",
    "d_dominant_seventh_f_sharp_sixth_octave",
    "e_flat_dominant_seventh_g_sixth_octave",
    "e_dominant_seventh_a_flat_sixth_octave",
    "f_dominant_seventh_a_sixth_octave",
    "f_sharp_dominant_seventh_b_flat_sixth_octave",
    "g_dominant_seventh_b_sixth_octave",
    "a_flat_dominant_seventh_c_sixth_octave",
    "a_dominant_seventh_d_flat_seventh_octave"]

dominant_seventh_second_inversion = [
    "f_sharp_dominant_seventh_d_flat_first_octave",
    "g_dominant_seventh_d_first_octave",
    "a_flat_dominant_seventh_e_flat_first_octave",
    "a_dominant_seventh_e_first_octave",
    "b_flat_dominant_seventh_f_first_octave",
    "b_dominant_seventh_f_sharp_first_octave",
    "c_dominant_seventh_g_first_octave",
    "d_flat_dominant_seventh_a_flat_first_octave",
    "d_dominant_seventh_a_first_octave",
    "e_flat_dominant_seventh_b_flat_first_octave",
    "e_dominant_seventh_b_first_octave",
    "f_dominant_seventh_c_first_octave",
    "f_sharp_dominant_seventh_d_flat_second_octave",
    "g_dominant_seventh_d_second_octave",
    "a_flat_dominant_seventh_e_flat_second_octave",
    "a_dominant_seventh_e_second_octave",
    "b_flat_dominant_seventh_f_second_octave",
    "b_dominant_seventh_f_sharp_second_octave",
    "c_dominant_seventh_g_second_octave",
    "d_flat_dominant_seventh_a_flat_second_octave",
    "d_dominant_seventh_a_second_octave",
    "e_flat_dominant_seventh_b_flat_second_octave",
    "e_dominant_seventh_b_second_octave",
    "f_dominant_seventh_c_second_octave",
    "f_sharp_dominant_seventh_d_flat_third_octave",
    "g_dominant_seventh_d_third_octave",
    "a_flat_dominant_seventh_e_flat_third_octave",
    "a_dominant_seventh_e_third_octave",
    "b_flat_dominant_seventh_f_third_octave",
    "b_dominant_seventh_f_sharp_third_octave",
    "c_dominant_seventh_g_third_octave",
    "d_flat_dominant_seventh_a_flat_third_octave",
    "d_dominant_seventh_a_third_octave",
    "e_flat_dominant_seventh_b_flat_third_octave",
    "e_dominant_seventh_b_third_octave",
    "f_dominant_seventh_c_third_octave",
    "f_sharp_dominant_seventh_d_flat_fourth_octave",
    "g_dominant_seventh_d_fourth_octave",
    "a_flat_dominant_seventh_e_flat_fourth_octave",
    "a_dominant_seventh_e_fourth_octave",
    "b_flat_dominant_seventh_f_fourth_octave",
    "b_dominant_seventh_f_sharp_fourth_octave",
    "c_dominant_seventh_g_fourth_octave",
    "d_flat_dominant_seventh_a_flat_fourth_octave",
    "d_dominant_seventh_a_fourth_octave",
    "e_flat_dominant_seventh_b_flat_fourth_octave",
    "e_dominant_seventh_b_fourth_octave",
    "f_dominant_seventh_c_fourth_octave",
    "f_sharp_dominant_seventh_d_flat_fifth_octave",
    "g_dominant_seventh_d_fifth_octave",
    "a_flat_dominant_seventh_e_flat_fifth_octave",
    "a_dominant_seventh_e_fifth_octave",
    "b_flat_dominant_seventh_f_fifth_octave",
    "b_dominant_seventh_f_sharp_fifth_octave",
    "c_dominant_seventh_g_fifth_octave",
    "d_flat_dominant_seventh_a_flat_fifth_octave",
    "d_dominant_seventh_a_fifth_octave",
    "e_flat_dominant_seventh_b_flat_fifth_octave",
    "e_dominant_seventh_b_fifth_octave",
    "f_dominant_seventh_c_fifth_octave",
    "f_sharp_dominant_seventh_d_flat_sixth_octave",
    "g_dominant_seventh_d_sixth_octave",
    "a_flat_dominant_seventh_e_flat_sixth_octave",
    "a_dominant_seventh_e_sixth_octave",
    "b_flat_dominant_seventh_f_sixth_octave",
    "b_dominant_seventh_f_sharp_sixth_octave",
    "c_dominant_seventh_g_sixth_octave",
    "d_flat_dominant_seventh_a_flat_sixth_octave",
    "d_dominant_seventh_a_sixth_octave",
    "e_flat_dominant_seventh_b_flat_sixth_octave",
    "e_dominant_seventh_b_sixth_octave",
    "f_dominant_seventh_c_sixth_octave"]

dominant_seventh_third_inversion = [
    "e_flat_dominant_seventh_d_flat_first_octave",
    "e_dominant_seventh_d_first_octave",
    "f_dominant_seventh_e_flat_first_octave",
    "f_sharp_dominant_seventh_e_first_octave",
    "g_dominant_seventh_f_first_octave",
    "a_flat_dominant_seventh_f_sharp_first_octave",
    "a_dominant_seventh_g_first_octave",
    "b_flat_dominant_seventh_a_flat_first_octave",
    "b_dominant_seventh_a_first_octave",
    "c_dominant_seventh_b_flat_first_octave",
    "d_flat_dominant_seventh_b_first_octave",
    "d_dominant_seventh_c_first_octave",
    "e_flat_dominant_seventh_d_flat_second_octave",
    "e_dominant_seventh_d_second_octave",
    "f_dominant_seventh_e_flat_second_octave",
    "f_sharp_dominant_seventh_e_second_octave",
    "g_dominant_seventh_f_second_octave",
    "a_flat_dominant_seventh_f_sharp_second_octave",
    "a_dominant_seventh_g_second_octave",
    "b_flat_dominant_seventh_a_flat_second_octave",
    "b_dominant_seventh_a_second_octave",
    "c_dominant_seventh_b_flat_second_octave",
    "d_flat_dominant_seventh_b_second_octave",
    "d_dominant_seventh_c_second_octave",
    "e_flat_dominant_seventh_d_flat_third_octave",
    "e_dominant_seventh_d_third_octave",
    "f_dominant_seventh_e_flat_third_octave",
    "f_sharp_dominant_seventh_e_third_octave",
    "g_dominant_seventh_f_third_octave",
    "a_flat_dominant_seventh_f_sharp_third_octave",
    "a_dominant_seventh_g_third_octave",
    "b_flat_dominant_seventh_a_flat_third_octave",
    "b_dominant_seventh_a_third_octave",
    "c_dominant_seventh_b_flat_third_octave",
    "d_flat_dominant_seventh_b_third_octave",
    "d_dominant_seventh_c_third_octave",
    "e_flat_dominant_seventh_d_flat_fourth_octave",
    "e_dominant_seventh_d_fourth_octave",
    "f_dominant_seventh_e_flat_fourth_octave",
    "f_sharp_dominant_seventh_e_fourth_octave",
    "g_dominant_seventh_f_fourth_octave",
    "a_flat_dominant_seventh_f_sharp_fourth_octave",
    "a_dominant_seventh_g_fourth_octave",
    "b_flat_dominant_seventh_a_flat_fourth_octave",
    "b_dominant_seventh_a_fourth_octave",
    "c_dominant_seventh_b_flat_fourth_octave",
    "d_flat_dominant_seventh_b_fourth_octave",
    "d_dominant_seventh_c_fourth_octave",
    "e_flat_dominant_seventh_d_flat_fifth_octave",
    "e_dominant_seventh_d_fifth_octave",
    "f_dominant_seventh_e_flat_fifth_octave",
    "f_sharp_dominant_seventh_e_fifth_octave",
    "g_dominant_seventh_f_fifth_octave",
    "a_flat_dominant_seventh_f_sharp_fifth_octave",
    "a_dominant_seventh_g_fifth_octave",
    "b_flat_dominant_seventh_a_flat_fifth_octave",
    "b_dominant_seventh_a_fifth_octave",
    "c_dominant_seventh_b_flat_fifth_octave",
    "d_flat_dominant_seventh_b_fifth_octave",
    "d_dominant_seventh_c_fifth_octave",
    "e_flat_dominant_seventh_d_flat_sixth_octave",
    "e_dominant_seventh_d_sixth_octave",
    "f_dominant_seventh_e_flat_sixth_octave",
    "f_sharp_dominant_seventh_e_sixth_octave",
    "g_dominant_seventh_f_sixth_octave",
    "a_flat_dominant_seventh_f_sharp_sixth_octave",
    "a_dominant_seventh_g_sixth_octave",
    "b_flat_dominant_seventh_a_flat_sixth_octave",
    "b_dominant_seventh_a_sixth_octave",
    "c_dominant_seventh_b_flat_sixth_octave",
    "d_flat_dominant_seventh_b_sixth_octave",
    "d_dominant_seventh_c_sixth_octave"]

major_root_chord_roots = list(range(12))*6 + [0, 1]
major_root_chord_types = [0]*74
major_root_root_notes = list(range(12))*6 + [0, 1]

major_first_inversion_chord_roots = [8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7]*6 + [8]
major_first_inversion_chord_types = [0]*73
major_first_inversion_root_notes = list(range(12))*6 + [0]

major_second_inversion_chord_roots = [5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4]*6
major_second_inversion_chord_types = [0]*72
major_second_inversion_root_notes = list(range(12))*6

minor_root_chord_roots = list(range(12))*6 + [0, 1]
minor_root_chord_types = [1]*74
minor_root_root_notes = list(range(12))*6 + [0, 1]

minor_first_inversion_chord_roots = [9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8]*6
minor_first_inversion_chord_types = [1]*72
minor_first_inversion_root_notes = list(range(12))*6

minor_second_inversion_chord_roots = [5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4]*6 + [5]
minor_second_inversion_chord_types = [1]*73
minor_second_inversion_root_notes = list(range(12))*6 + [0]

dominant_seventh_root_chord_roots = list(range(12))*5 + list(range(11))
dominant_seventh_root_chord_types = [2]*71
dominant_seventh_root_root_notes = list(range(12))*5 + list(range(11))

dominant_seventh_first_inversion_chord_roots = [8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7]*6 + [8]
dominant_seventh_first_inversion_chord_types = [2]*73
dominant_seventh_first_inversion_root_notes = list(range(12))*6 + [0]

dominant_seventh_second_inversion_chord_roots = [5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4]*6
dominant_seventh_second_inversion_chord_types = [2]*72
dominant_seventh_second_inversion_root_notes = list(range(12))*6

dominant_seventh_third_inversion_chord_roots = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1]*6
dominant_seventh_third_inversion_chord_types = [2]*72
dominant_seventh_third_inversion_root_notes = list(range(12))*6

chord_lists = [major_root, major_first_inversion, major_second_inversion,
    minor_root, minor_first_inversion, minor_second_inversion,
    dominant_seventh_root, dominant_seventh_first_inversion,
    dominant_seventh_second_inversion, dominant_seventh_third_inversion]

chord_roots_list = [major_root_chord_roots, major_first_inversion_chord_roots, major_second_inversion_chord_roots,
    minor_root_chord_roots, minor_first_inversion_chord_roots, minor_second_inversion_chord_roots,
    dominant_seventh_root_chord_roots, dominant_seventh_first_inversion_chord_roots,
    dominant_seventh_second_inversion_chord_roots, dominant_seventh_third_inversion_chord_roots]

chord_types_list = [major_root_chord_types, major_first_inversion_chord_types, major_second_inversion_chord_types,
    minor_root_chord_types, minor_first_inversion_chord_types, minor_second_inversion_chord_types,
    dominant_seventh_root_chord_types, dominant_seventh_first_inversion_chord_types,
    dominant_seventh_second_inversion_chord_types, dominant_seventh_third_inversion_chord_types]

root_notes_list = [major_root_root_notes, major_first_inversion_root_notes, major_second_inversion_root_notes,
    minor_root_root_notes, minor_first_inversion_root_notes, minor_second_inversion_root_notes,
    dominant_seventh_root_root_notes, dominant_seventh_first_inversion_root_notes,
    dominant_seventh_second_inversion_root_notes, dominant_seventh_third_inversion_root_notes]

chord_directories = ["major_root/", "major_first_inversion/", "major_second_inversion/",
                     "minor_root/", "minor_first_inversion/", "minor_second_inversion/",
                     "dominant_seventh_root/", "dominant_seventh_first_inversion/",
                     "dominant_seventh_second_inversion/", "dominant_seventh_third_inversion/"]

errors = [0]*17

for i in range(len(chord_directories)):
    for j in range(len(chord_lists[i])):
        filepath = "chordrecordings/" + chord_directories[i] + chord_lists[i][j] + ".wav"
        chord_roots, chord_types, root_notes = audio_to_chord.spectrogram_to_chord(filepath)
        errors[int(audio_to_chord.error(chord_roots, chord_roots_list[i][j])*len(chord_roots))] += 1
        errors[int(audio_to_chord.error(chord_types, chord_types_list[i][j])*len(chord_types))] += 1
        errors[int(audio_to_chord.error(root_notes, root_notes_list[i][j])*len(root_notes))] += 1

fig = plt.figure(figsize=(20, 12))
xticks = np.arange(0, 17, 1)*25/4
plt.bar(xticks, errors, width=8, color="black")

font = {"family": "serif", "size": 16}
matplotlib.rc("font", **font)

ax = fig.gca()
major_yticks = np.arange(0, 1401, 100)
minor_yticks = np.arange(0, 1401, 20)
ax.set_xticks(xticks)
ax.set_yticks(major_yticks)
ax.set_yticks(minor_yticks, minor=True)
ax.grid(which="both")
ax.grid(which="minor", alpha=0.2)
ax.grid(which="major", alpha=0.5)
plt.axis([0, 100, 0, 1400])

plt.xlabel("Error (%)", **font)
plt.ylabel("Number of audio clips", **font)
plt.title("Error distribution in audio clips", **font)
plt.savefig("error_bar.png", bbox_inches="tight", pad_inches=0.5)