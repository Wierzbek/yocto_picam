# Writing a New Recipe:
# https://docs.yoctoproject.org/1.6/dev-manual/dev-manual.html#new-recipe-writing-a-new-recipe

SUMMARY = "Raspberry Pi camera module driver using GStreamer"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://basic-tutorial-1.c"

S = "${WORKDIR}"

#inherit gstreamer-1.0

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	${CC} basic-tutorial-1.c -o basic-tutorial `pkg-config --cflags --libs gstreamer-1.0`
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 basic-tutorial ${D}${bindir}
}

DEPENDS = "gstreamer1.0"
