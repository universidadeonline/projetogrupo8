import { IconButton } from "native-base";
import { FontAwesome5 } from "@expo/vector-icons";
import { useNavigation } from "@react-navigation/native";
import { DrawerNavigation } from "../routes/drawer.routes";

interface MenuProps {
  type: "normal" | "float";
}

export function Menu({ type }: MenuProps) {
  const navigation = useNavigation<DrawerNavigation>();
  return (
    <IconButton
      h={50}
      w={50}
      icon={<FontAwesome5 name="bars" size={24} color="black" />}
      onPress={() => navigation.openDrawer()}
      borderRadius="full"
      style={
        type === "float"
          ? {
              position: "absolute",
              right: 30,
              bottom: 30,
              backgroundColor: "white",
            }
          : {}
      }
    />
  );
}
