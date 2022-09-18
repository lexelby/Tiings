package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_01
   extends TilingType
{
   public TilingTypeN6_01(){
      super( "N6-1", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{360,180,500,180};
      paramDef = new int[]{160, 65, 70, 55};
      paramName = new String[]{ "Angle 1", "Angle 2", "Point Distance", "Point Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,4,5, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 5,4, 2,4,5, 0},

            {0, 1,2, 0,0,1, 1},
            {1, 5,4, 4,4,5, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 5,4, 6,4,5, 1},
      };
      info = "a=d\nb=c\nA+B+C=360\n(D+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = 90-paramValues[0]/2.;
      double b = paramValues[1];
      double ln3 = ln * paramValues[2]/100.;
      double c = paramValues[3];
      if( a<0){
         b = Math.max(-a, b);
         b = Math.min(180+a, b);
      }
      double dx1 = ln * Math.cos( a * DEG2RAD);
      double dy1 = ln * Math.sin( a * DEG2RAD);
      double dx2 = ln * Math.cos( b * DEG2RAD);
      double dy2 = ln * Math.sin( b * DEG2RAD);
      double dx3 = dx1 + ln3 * Math.cos( c * DEG2RAD);
      double dy3 =       ln3 * Math.sin( c * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, dx1, -dy1);
      baseTile.setPoint(2, dx1*2, 0);
      baseTile.setPoint(3, dx2+dx1*2, dy2);
      baseTile.setPoint(4, dx2+dx3, dy2+dy3);
      baseTile.setPoint(5, dx2, dy2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(0);
   }
}