def vigenere_encrypt(plain_metin, anahtar):
    sifrelenmis_metin = ''

    # Anahtarın metin boyunca tekrarlanması
    anahtar_tekrar = (anahtar * (len(plain_metin) // len(anahtar))) + anahtar[:len(plain_metin) % len(anahtar)]

    # Her bir harfi şifreleme işlemi
    for acik_karakter, anahtar_karakter in zip(plain_metin, anahtar_tekrar):
        if acik_karakter.isalpha():
            # Alfasayısal karakterler şifrelenir
            # Büyük harfler için 'A', küçük harfler için 'a' referans alınır
            base = 'A' if acik_karakter.isupper() else 'a'
            sifrelenmis_karakter = chr((ord(acik_karakter) + ord(anahtar_karakter) - 2 * ord(base)) % 26 + ord(base))
            sifrelenmis_metin += sifrelenmis_karakter
        else:
            # Alfasayısal olmayan karakterler değişmeden kalır
            sifrelenmis_metin += acik_karakter

    return sifrelenmis_metin


def vigenere_decrypt(sifrelenmis_metin, anahtar):
    """Vigenère şifreleme işleminin çözülmesi"""
    cozulmus_metin = ''

    # Anahtarın şifrelenmiş metin boyunca tekrarlanması
    anahtar_tekrar = (anahtar * (len(sifrelenmis_metin) // len(anahtar))) + anahtar[
                                                                            :len(sifrelenmis_metin) % len(anahtar)]

    # Her bir harfi çözme işlemi
    for sifreli_karakter, anahtar_karakter in zip(sifrelenmis_metin, anahtar_tekrar):
        if sifreli_karakter.isalpha():
            # Alfasayısal karakterler çözülür
            # Büyük harfler için 'A', küçük harfler için 'a' referans alınır
            base = 'A' if sifreli_karakter.isupper() else 'a'
            cozulmus_karakter = chr((ord(sifreli_karakter) - ord(anahtar_karakter) + 26) % 26 + ord(base))
            cozulmus_metin += cozulmus_karakter
        else:
            # Alfasayısal olmayan karakterler değişmeden kalır
            cozulmus_metin += sifreli_karakter

    return cozulmus_metin


# Örnek kullanım
acik_metin = "MERHABA"
anahtar = "ANAHTAR"

sifrelenmis_metin = vigenere_encrypt(acik_metin, anahtar)
cozulmus_metin = vigenere_decrypt(sifrelenmis_metin, anahtar)

# Sonuçların gösterilmesi
print(f"Açık Metin: {acik_metin}")
print(f"Şifreli Metin: {sifrelenmis_metin}")
print(f"Çözülmüş Metin: {cozulmus_metin}")
