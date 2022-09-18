package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_49a
   extends TilingType
{
   public TilingTypeN4_49a(){
      super( "N4-49a: s split rectangle", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 60, 66, 50};
      paramName = new String[]{ "Aspect", "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 2,0,1, 1},
      };
      info = "A=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;  // base
      double h = 2 * (1.5 - w);
      double h1 = h * getParam(paramValues,1)/100.;  // side1
      double h2 = h - h1;  // side2

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0, h1);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = 2 * getParam(paramValues,2)/100. - 1;  // offset
      offsets[0] = tiles[1].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[1].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[1].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[1].getY(2)-tiles[1].getY(3);
      if( os>=0 ){
         offsets[2] += os * offsets[0];
         offsets[3] += os * offsets[1];
      }else{
         offsets[0] += os * offsets[2];
         offsets[1] += os * offsets[3];
      }
   }
}
