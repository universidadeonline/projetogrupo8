import { IIconProps, IconButton } from "native-base";
import { FontAwesome5 } from "@expo/vector-icons";
import { useNavigation } from "@react-navigation/native";

export function ButtonBack({ ...rest }: IIconProps) {
  const navigation = useNavigation();
  return (
    <IconButton
      icon={<FontAwesome5 name="arrow-left" size={24} color="black" />}
      onPress={() => navigation.goBack()}
      borderRadius="full"
      {...rest}
    />
  );
}
