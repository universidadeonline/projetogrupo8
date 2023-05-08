import { Fab, IconButton } from "native-base";
import { FontAwesome5 } from "@expo/vector-icons";
import { useNavigation } from "@react-navigation/native";
import { DrawerNavigation } from "../routes/drawer.routes";

interface MenuProps {
  type: "normal" | "float";
}

export function Menu({ type }: MenuProps) {
  const navigation = useNavigation<DrawerNavigation>();
  return type == "float" ? (
    <Fab
      h={60}
      w={60}
      renderInPortal={false}
      shadow={2}
      backgroundColor="white"
      icon={<FontAwesome5 name="bars" size={24} color="black" />}
      onPress={() => navigation.openDrawer()}
    />
  ) : (
    <IconButton
      h={50}
      w={50}
      icon={<FontAwesome5 name="bars" size={24} color="black" />}
      onPress={() => navigation.openDrawer()}
      borderRadius="full"
    />
  );
}
