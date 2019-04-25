#!/usr/bin/env bash
for png_file in "$1"/*/*.png
do
	if [[ $(file -b ${png_file}) =~ JPEG ]];
	then
		echo cest un jpeg $png_file
  		mv "$png_file" "${png_file%.png}.jpg"
	fi
done

