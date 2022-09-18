package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_61
   extends TilingType
{
   public TilingTypeN4_61(){
      super( "N4-61", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 20};
      paramName = new String[]{ "Relative length 1", "Relative length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,0, 0},
            {0, 0,3, 1,0,1, 0},
            {1, 3,0, 2,1,0, 0},
      };
      info = "A=90\nC=90\n(B+D=180)";
   }
   public void recalcBase(double[] paramValues) {
      double diag = 1.;
      
      double f1 = getParam(paramValues,0)/100.;
      double g1 = 1-f1;
      double h1 = Math.sqrt(f1*f1+g1*g1);
      f1 *= diag / h1;
      g1 *= diag / h1;

      double f2 = getParam(paramValues,1)/100.;
      double g2 = 1-f2;
      double h2 = Math.sqrt(f2*f2+g2*g2);
      f2 *= diag / h2;
      g2 *= diag / h2;

      double b = Math.atan2(f1,g1) + Math.atan2(f2,g2);

      double c = g2 * Math.cos(b);
      double s = g2 * Math.sin(b);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, g1, 0);
      baseTile.setPoint(2, g1-c, s);
      baseTile.setPoint(3, 0, f1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(2);
   }
}
